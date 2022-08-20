//package com.bankapp.backup;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//@Repository
//@Primary
//@Profile("prod")
//public class AccountDaoImplJdbc implements AccountDao {
//
//	private DataSource datasource;
//	
//	
//	@Autowired
//	public AccountDaoImplJdbc(DataSource datasource) {
//		this.datasource = datasource;
//	}
//
//	@Override
//	public List<Account> getAll() {
//		List<Account> accounts = new ArrayList<Account>();
//
//		Connection connection = null;
//		try {
//			connection = datasource.getConnection();
//		
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from account");
//
//			while (rs.next()) {
//				accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		
//		}
//
//		return accounts;
//	}
//
//	@Override
//	public Account getById(int id) {
//		return null;
//	}
//
//	@Override
//	public void updateAccount(Account account) {
//		
//	}
//
//	@Override
//	public void addAccount(Account account) {
//		//
//	}
//
//	@Override
//	public void deleteAccount(int id) {
//		//
//	}
//
//}
