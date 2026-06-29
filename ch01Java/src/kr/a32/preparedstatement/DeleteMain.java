package kr.a32.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;

public class DeleteMain {
	public static void main(String arg[]){	
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try{
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("번호:");
			int num = Integer.parseInt(br.readLine());

			conn = DBUtil.getConnection();	
			System.out.println("test3 테이블에 데이터를 삭제합니다.");
			sql = "DELETE FROM test3 WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			System.out.println(count+"개 행을 삭제했습니다.");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.executeClose(null, pstmt, conn);

			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
}
