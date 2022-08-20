package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.Account;

//BL = FR+ NFR
public interface AccountService {
	public List<Account> getAll();

	public Account getById(int id);

	public void updateAccount(Account account);

	public void transfer(int fromAccNo, int toAccountNo, double amount);

	public void deposit(int accNo, double amount);

	public void withdraw(int accNo, double amount);
	
	public void createAccount(Account account);
	

}






