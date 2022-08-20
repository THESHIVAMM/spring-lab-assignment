package com.bankapp.model.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
//@Primary
public class AccountDaoImplMap implements AccountDao {

	private Map<Integer, Account> accounts = new HashMap<>();

	public AccountDaoImplMap() {
		accounts.put(1, new Account(1, "raj", 1000.00));
		accounts.put(2, new Account(2, "ekta", 1000.00));
	}

	@Override
	public List<Account> getAll() {
		System.out.println("using map");
		return new ArrayList<Account>(accounts.values());
	}

	@Override
	public Account getById(int id) {
		return accounts.get(id);
	}

	@Override
	public void updateAccount(Account account) {
		accounts.put(account.getId(), account);
	}

	@Override
	public void addAccount(Account account) {
		//
	}

	@Override
	public void deleteAccount(int id) {
		//
	}

}
