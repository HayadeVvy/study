package kr.a33.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class SelectSearchMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							      System.in));
			System.out.print("제목 검색어:");
			String keyword = br.readLine();
			
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM test4 "
				+ "WHERE subject LIKE '%' || ? || '%' "
				+ "ORDER BY num DESC";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, keyword);
			
			//JDBC 수행 4단계 : SQL문을 실행해서 결과행들을
			//                ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {  //첫 번째 행
				System.out.println("번호\t작성자\t등록일\t\t제목");
				do {
					System.out.print(rs.getInt("num") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getDate("reg_date") + "\t");
					System.out.print(rs.getString("subject") + "\n");
				}while(rs.next());
			}else {
				System.out.println(
						     "검색된 데이터가 없습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
			if(br!=null)try {br.close();}
			             catch(IOException e) {}
		}
	}
}



