package kr.a36.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

/*
 * DAO : Data Access Object
 *       데이터베이스의 데이터를 전문적으로 호출하고 제어하는
 *       객체
 */
public class NoteDAO {
	//글 쓰기
	public void insertInfo(String name,
			               String passwd,
			               String subject,
			               String content,
			               String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO note (num,name,passwd,"
				+ "subject,content,email,reg_date) "
				+ "VALUES (note_seq.nextval,?,?,?,?,?,SYSDATE)";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(++cnt, name);
			pstmt.setString(++cnt, passwd);
			pstmt.setString(++cnt, subject);
			pstmt.setString(++cnt, content);
			pstmt.setString(++cnt, email);
			
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(
					count + "개의 행을 삽입했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//목록 보기
	public void selectInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM note ORDER BY num DESC";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			System.out.println("-".repeat(30));
			
			if(rs.next()) {
				System.out.println("번호\t작성자\t작성일\t\t제목");
				do {
					System.out.print(rs.getInt("num") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getDate("reg_date") + "\t");
					System.out.print(rs.getString("subject") + "\n");
				}while(rs.next());
			}else {
				System.out.println("표시할 데이터가 없습니다.");
			}			
			System.out.println("-".repeat(30));			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//상세글 보기
	public void selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM note WHERE num=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);			
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBc 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("번호:"+rs.getInt("num"));
				System.out.println(
						"이름:"+rs.getString("name"));
				System.out.println(
					"비밀번호:"+rs.getString("passwd"));
				System.out.println(
					"제목:"+rs.getString("subject"));
				System.out.println(
					"내용:"+rs.getString("content"));
				
				String email = rs.getString("email");
				if(email==null) email = "";
				
				System.out.println("이메일:"+email);
				System.out.println(
					"작성일:"+rs.getDate("reg_date"));				
			}else {
				System.out.println("검색된 정보가 없습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//조회하는 레코드가 존재하는지 여부 체크
	//글 수정
	//글 삭제
	
}




