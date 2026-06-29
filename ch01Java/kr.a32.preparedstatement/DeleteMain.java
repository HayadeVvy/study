package kr.a32.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;

public class DeleteMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try{
			conn = DBUtil.getConnection();	
			System.out.println("test3 테이블에 데이터를 삭제합니다.");
			sql = "delete from test3 where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			int count = pstmt.executeUpdate();
			System.out.println(count+"개 행을 삭제했습니다.");
			
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
