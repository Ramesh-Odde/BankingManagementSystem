package com.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entity.Account;
import com.bankapp.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository repo;

	@Override
	public Account createAccount(Account account) {
		Account account_saving = repo.save(account);
		return account_saving;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> fetchbyId = repo.findById(accountNumber);
		if (fetchbyId.isEmpty()) {
			throw new RuntimeException("Account doesn't exist with that number");
		}
		Account accountFound = fetchbyId.get();
		return accountFound;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> listOfAccounts = repo.findAll();
		return listOfAccounts;
	}

	@Override
	public Account depositeAmount(Long accountNumber, Double amount) {
		Account accountDetails = getAccountDetailsByAccountNumber(accountNumber);
		Double updatedBalance = accountDetails.getAccount_balance() + amount;
		accountDetails.setAccount_balance(updatedBalance);
		repo.save(accountDetails);

		return accountDetails;
	}

	@Override
	public Account withdrawAmount(Long accoutNumber, Double amount) {
		Optional<Account> findingAccount = repo.findById(accoutNumber);
		if (findingAccount.isEmpty()) {
			throw new RuntimeException("Account details not Found!");
		}
		Account accountDetails = findingAccount.get();
		if (amount > accountDetails.getAccount_balance()) {
			throw new RuntimeException("Insufisient Balance");
		}
		Double updatedBalance = accountDetails.getAccount_balance() - amount;
		accountDetails.setAccount_balance(updatedBalance);
		repo.save(accountDetails);
		return accountDetails;
	}

	@Override
	public Boolean closeAccount(Long accountNumber) {
		Boolean flag = false;
		Optional<Account> findingAccount = repo.findById(accountNumber);
		if (findingAccount.isEmpty()) {
			throw new RuntimeException("There is no account to delete");
		}
		flag = true;
		Account accountDetails = findingAccount.get();
		repo.delete(accountDetails);
		return flag;
	}

}
