package com.bankapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entity.Account;

@Repository
@Primary
public class AccountDaoImplHib implements AccountDao {

	private SessionFactory sessionFactory;

	@Autowired
	public AccountDaoImplHib(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();// hiberate session is create by spring
	}

	@Override
	public List<Account> getAll() {
		// SQL vs HQL (i walk in object i talk in object)
		return getSession().createQuery("select a from Account a", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		return getSession().get(Account.class, id);
	}

	@Override
	public void updateAccount(Account account) {
		getSession().merge(account);
	}

	@Override
	public void addAccount(Account account) {
		getSession().save(account);
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete = getById(id);
		getSession().remove(accountToDelete);
	}

}
