package kr.a33.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class SelectListMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM test4 ORDER BY num DESC";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
		    pstmt = conn.prepareStatement(sql);
		    //JDBC 수행 4단계 : SQL문을 실행해서 결과행들을 
		    //               ResultSet에 담아서 반환
		    rs = pstmt.executeQuery();
		    System.out.println("번호\t제목\t등록일\t\t작성자");
		    while(rs.next()) {
		    	System.out.print(rs.getInt("num") + "\t");
		    	System.out.print(rs.getString("subject") + "\t");
		    	System.out.print(rs.getDate("reg_date") + "\t");
		    	System.out.print(rs.getString("name") + "\n");
		    }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
	}
}






