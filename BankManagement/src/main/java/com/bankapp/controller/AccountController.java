package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	// create account

	@Autowired
	AccountService service;

	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account creating_acount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(creating_acount);
	}

	@GetMapping("/{accountNumber}")
	public ResponseEntity<Account> getAccountByNumber(@PathVariable Long accountNumber) {
		Account fetchByNumber = service.getAccountDetailsByAccountNumber(accountNumber);
		return ResponseEntity.status(HttpStatus.FOUND).body(fetchByNumber);
	}

	@GetMapping("/all")
	public List<Account> getAllAccounts() {
		List<Account> allAccountDetails = service.getAllAccountDetails();
		return allAccountDetails;
	}

	@PutMapping("/deposite/{accountNumber}/{amount}")
	public ResponseEntity<Account> depositeAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account updatingAccountBalance = service.depositeAmount(accountNumber, amount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatingAccountBalance);
	}

	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public ResponseEntity<Account> withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account updatedBalance = service.withdrawAmount(accountNumber, amount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBalance);
	}

	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		Boolean closeAccount = service.closeAccount(accountNumber);
		if(closeAccount) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Records of the account deleted");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account doesn't exist!");
	}
}
