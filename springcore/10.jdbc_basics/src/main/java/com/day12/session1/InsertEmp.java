package com.day12.session1;
import java.sql.*;
public class InsertEmp {
	public static void main(String[] args) {
		
		
		//Statement vs PreparedSatatement vs CallableStamtement
		
		//there is possibility of sql injection (sec ven..) with Statement
		//SQL injection 
		//select * from  emp where id=11 or 1=1;
		
		Connection connection=ConnectionFactory.getConnection();
		try {
			PreparedStatement pstmt=connection.
					prepareStatement("insert into emp1(ename, city, desi, salary) values(?,?,?,?)");
			
			pstmt.setString(1, "umesh");
			pstmt.setString(2, "delhi");
			pstmt.setString(3, "sales");
			pstmt.setDouble(4, 87000.00);
			
			int noOfRowsEffeted = pstmt.executeUpdate();
			
			System.out.println(noOfRowsEffeted);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
