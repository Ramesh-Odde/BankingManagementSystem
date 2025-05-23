package com.bankapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_number;

	@Column
	private String account_hoder_name;

	@Column
	private Double account_balance;

	public Account() {
		super();
	}

	public Account(String account_hoder_name, Double account_balance) {
		super();
		this.account_hoder_name = account_hoder_name;
		this.account_balance = account_balance;
	}

	public Long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}

	public String getAccount_hoder_name() {
		return account_hoder_name;
	}

	public void setAccount_hoder_name(String account_hoder_name) {
		this.account_hoder_name = account_hoder_name;
	}

	public Double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", account_hoder_name=" + account_hoder_name
				+ ", account_balance=" + account_balance + "]";
	}

}
