package com.bankapp.model.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
@Primary
@Profile("prod")
public class AccountDaoImplJdbc implements AccountDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDaoImplJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		//i want to get all the records from data resultset---> i need accounts object.. for that i need to create a class
		//that class implements RowMapper inteface
		
		return jdbcTemplate.query("select * from account", new AccountRowMapper());
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject("select * from account where id=?", new AccountRowMapper(), id);
	}

	@Override
	public void updateAccount(Account account) {
		String UPDATE_QUERY="update account set balance =? where id=?";
		jdbcTemplate.update(UPDATE_QUERY, new Object[] {account.getBalance(), account.getId()});
	}

	@Override
	public void addAccount(Account account) {
		String INSERT_QUERY="insert into account(name, balance) values(?,?)";
		jdbcTemplate.update(INSERT_QUERY, new Object[] {account.getName(), account.getBalance()});
	}

	@Override
	public void deleteAccount(int id) {
		//
		String DLETE_QUERY="delele form account where id=?";
		jdbcTemplate.update(DLETE_QUERY,id);
	}

}
