package kr.a29.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id="user01";
		String db_password="a1234";
		Connection conn = null;
		try {
			Class.forName(db_driver);
			
			conn = 
					DriverManager.getConnection(
							db_url,db_id,db_password);
			System.out.println(
				"Connection 객체가 생성되었습니다.");		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();}
			               catch(Exception e) {}
		}
	}
}







