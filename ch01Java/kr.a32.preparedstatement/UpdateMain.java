package kr.a32.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;

public class UpdateMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try{
			conn = DBUtil.getConnection();	
			System.out.println("test3 테이블에 데이터를 수정합니다.");
			sql = "update test3 set title = ?, name = ?, memo = ?, email = ? where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "");
			pstmt.setString(2, "");
			pstmt.setString(3, "");
			pstmt.setString(4, "");
			pstmt.setInt(5, 0);
			int count = pstmt.executeUpdate();
			System.out.println(count+"개 행의 정보를 수정했습니다.");

		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}	
	}
}
