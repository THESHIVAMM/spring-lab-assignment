package com.bankapp.model.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.model.entity.Account;

public interface AccountService {
	
	public List<Account> getAll();

	public Account getById(int id);

	public Account updateAccount(Account account);

	public void transfer(int fromAccNo, int toAccountNo, BigDecimal amount);

	public void deposit(int accNo, BigDecimal amount);

	public void withdraw(int accNo, BigDecimal amount);
	
	public Account createAccount(Account account);
	
	public Account deleteAccount(int id);
}
