
package com.bankapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.model.entity.Account;
import com.bankapp.model.persistance.AccountDao;

//BL =FR+ NFR
@Service(value = "accountService")
@Transactional// it is so imp topic ...but now we can left it :)
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account = accountDao.getById(id);
		if (account == null) {
			throw new BankAccountNotFoundException("account with id " + id + " is not found");
		}
		return account;
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	@Override
	public void transfer(int fromAccNo, int toAccountNo, double amount) {

		Account fromAcc = getById(fromAccNo);
		Account toAcc = getById(toAccountNo);

		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);

		accountDao.updateAccount(fromAcc);
//		if(1==1)
//			throw new RuntimeException();
		
		accountDao.updateAccount(toAcc);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

	}

	@Override
	public void deposit(int accNo, double amount) {
		Account account = getById(accNo);
		account.setBalance(account.getBalance() + amount);
		accountDao.updateAccount(account);
		System.out.println("deposit is done");
	}

	@Override
	public void withdraw(int accNo, double amount) {
		Account account = getById(accNo);
		account.setBalance(account.getBalance() - amount);
		accountDao.updateAccount(account);
		System.out.println("deposit is done");

	}

}
