package kr.a32.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class SelectMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try{
			conn = DBUtil.getConnection();	
			sql = "SELECT * FROM test3 ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("번호\t제목\t등록일\t\t작성자");
			while(rs.next()){
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("title")+"\t");
				System.out.print(rs.getDate("reg_date")+"\t");
				System.out.print(rs.getString("name")+"\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}
