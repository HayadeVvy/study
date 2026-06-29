package kr.a33.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;
/*
 * 작업        처리 문장
 * Create -> INSERT
 * Read ->   SELECT
 * Update -> UPDATE
 * Delete -> DELETE
 */

public class InsertMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(
					new InputStreamReader(
							      System.in));
			System.out.print("제목:");
			String subject = br.readLine();
			System.out.print("이름:");
			String name = br.readLine();
			System.out.print("내용:");
			String content = br.readLine();
			System.out.print("이메일:");
			String email = br.readLine();
			
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "INSERT INTO test4 (num,"
				+ "subject,name,content,email) "
				+ "VALUES (test4_seq.nextval,?,?,?,?)";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, subject);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			pstmt.setString(4, email);
			
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 추가했습니다.");			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
			
			if(br!=null)try {br.close();}
			              catch(IOException e) {}
		}
		
	}
}


