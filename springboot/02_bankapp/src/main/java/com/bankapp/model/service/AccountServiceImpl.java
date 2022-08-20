package com.bankapp.model.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.model.entity.Account;
import com.bankapp.model.presistance.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepo;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getById(int id) {
		// Optinal
		return accountRepo.findById(id).orElseThrow(() -> new BankAccountNotFoundException("account not found"));
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepo.save(account);// same method for saving as well as updating
	}

	@Override
	public void transfer(int fromAccNo, int toAccountNo, BigDecimal amount) {
		Account fromAcc = getById(fromAccNo);
		Account toAcc = getById(toAccountNo);

		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		toAcc.setBalance(toAcc.getBalance().add(amount));

		accountRepo.save(fromAcc);
		accountRepo.save(toAcc);
	}

	@Override
	public void deposit(int accNo, BigDecimal amount) {
		Account acc = getById(accNo);
		acc.setBalance(acc.getBalance().add(amount));
		accountRepo.save(acc);
	}

	@Override
	public void withdraw(int accNo,  BigDecimal amount) {
		Account acc = getById(accNo);
		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepo.save(acc);
	}

	@Override
	public Account createAccount(Account account) {
		accountRepo.save(account);
		return account;
	}

	@Override
	public Account deleteAccount(int id) {
		Account acc = getById(id);
		accountRepo.delete(acc);
		return acc;
	}

}
