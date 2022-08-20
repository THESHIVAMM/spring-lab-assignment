package com.day12.session1;

import java.sql.*;

public class HelloWorldJdbc {

	public static void main(String[] args) {
		// load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver is loaded...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Connection
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/oraapp?useSSL=false", "root", "root");
			// now i want to print all records
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from account");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":"  + rs.getString(2) + ": "
						+ rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
