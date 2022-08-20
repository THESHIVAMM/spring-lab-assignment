package com.bankapp.model.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
//you need to teach spring jdbc how to convert the rs --> account object for that i need to write a rowmapper
public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account=new Account();
		account.setId(rs.getInt(1));
		account.setName(rs.getString(2));
		account.setBalance(rs.getDouble(3));
		
		return account;
	}

}
