package com.bankapp.service;

import java.util.List;

import com.bankapp.entity.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public Account getAccountDetailsByAccountNumber(Long accountNumber);

	public List<Account> getAllAccountDetails();

	public Account depositeAmount(Long accountNumber, Double amount);

	public Account withdrawAmount(Long accoutNumber, Double amount);

	public Boolean closeAccount(Long accountNumber);

}
