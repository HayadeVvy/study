package kr.a38.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.util.DBUtil;

/*
 * DAO : Data Access Object
 *       데이터베이스의 데이터를 전문적으로
 *       호출하고 제어하는 객체
 */
public class ScoreDAO {
	//성적 입력
	public int insertInfo(ScoreDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;//? 번호 처리
		int count = 0;//삽입한 행의 개수 처리
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO score (num,name,"
				+ "korean,english,math,reg_date)"
				+ "VALUES (score_seq.nextval,"
				+ "?,?,?,?,SYSDATE)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(++cnt, dto.getName());
			pstmt.setInt(++cnt, dto.getKorean());
			pstmt.setInt(++cnt, dto.getEnglish());
			pstmt.setInt(++cnt, dto.getMath());
			//JDBC 수행 4단계
			count = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	//목록 보기
	public List<ScoreDTO> selectInfo(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ScoreDTO> list = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM score ORDER BY num DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			//ArrayList 생성
			list = new ArrayList<ScoreDTO>();
			while(rs.next()) {
				ScoreDTO dto = new ScoreDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setKorean(rs.getInt("korean"));
				dto.setEnglish(rs.getInt("english"));
				dto.setMath(rs.getInt("math"));
				dto.setReg_date(rs.getDate("reg_date"));
				
				//ArrayList에 ScoreDTO를 저장
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return list;
	}
	//성적 상세
	public ScoreDTO selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScoreDTO dto = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM score WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ScoreDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setKorean(rs.getInt("korean"));
				dto.setEnglish(rs.getInt("english"));
				dto.setMath(rs.getInt("math"));
				dto.setReg_date(rs.getDate("reg_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	//조회하는 레코드가 존재하는지 여부 체크
	public int checkRecord(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM score WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = 1;//레코드가 존재하는 경우
			}			
		}catch(Exception e) {
			count = -1;
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}		
		return count;
	}
	
	//성적 수정
	public int updateInfo(ScoreDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		int count = 0;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "UPDATE score SET name=?,korean=?,"
				+ "english=?,math=? WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터를 바인딩
			pstmt.setString(++cnt, dto.getName());
			pstmt.setInt(++cnt, dto.getKorean());
			pstmt.setInt(++cnt, dto.getEnglish());
			pstmt.setInt(++cnt, dto.getMath());
			pstmt.setInt(++cnt, dto.getNum());
			
			//JDBC 수행 4단계
			count = pstmt.executeUpdate();
			
		}catch(Exception e) {
			count = -1;
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}		
		return count;
	}
	//성적 삭제
	public int deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "DELETE FROM score WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			//JDBC 수행 4단계
			count = pstmt.executeUpdate();
		}catch(Exception e) {
			count = -1;
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}		
		return count;
	}
}










