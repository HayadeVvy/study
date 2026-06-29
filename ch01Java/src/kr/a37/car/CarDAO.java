package kr.a37.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

/*
 * DAO : Data Access Object
 *       데이터베이스의 데이터를 전문적으로
 *       호출하고 제어하는 객체
 */
public class CarDAO {
	//자동차 정보 등록
	public void insertCar(String name,
			              String color,
			              String maker,
			              int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO car (num,name,"
				+ "color,maker,price,reg_date) "
				+ "VALUES (car_seq.nextval,"
				+ "?,?,?,?,SYSDATE)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(++cnt, name);
			pstmt.setString(++cnt, color);
			pstmt.setString(++cnt, maker);
			pstmt.setInt(++cnt, price);	
			
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
	public void selectCar() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM car ORDER BY num DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			System.out.println("-".repeat(30));
			if(rs.next()) {
				System.out.println("번호\t이름\t제조사\t등록일");
				do {
					System.out.print(rs.getInt("num") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getString("maker") + "\t");
					System.out.println(rs.getDate("reg_date") + "\t");
				}while(rs.next());
			}else {
				System.out.println(
						"등록된 데이터가 없습니다.");
			}			
			System.out.println("-".repeat(30));			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//자동차 상세 보기
	public void selectDetailCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM car WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(
					"번호:" + rs.getInt("num"));
				System.out.println(
					"이름:" + rs.getString("name"));
				System.out.println(
					"색상:" + rs.getString("color"));
				System.out.println(
					"제조사:" + rs.getString("maker"));
				System.out.println(
					"가격:" + rs.getString("price"));
				System.out.println(
					"등록일:" + rs.getDate("reg_date"));
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
			sql = "SELECT * FROM car WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//SQL문의 ?에 데이터 할당
			pstmt.setInt(1, num);

			//JDBC 수행 4단계
			rs = pstmt.executeQuery();

			if(rs.next()) {
				count = 1;//레코드가 존재할 때 1 저장
			}
		}catch(Exception e) {
			count = -1;
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);		
		}
		return count;
	}
	//자동차 정보 수정
	public void updateCar(int num,String name,
			             String color,
			             String maker,
			             int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "UPDATE car SET name=?,color=?,"
				+ "maker=?,price=? WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(++cnt, name);
			pstmt.setString(++cnt, color);
			pstmt.setString(++cnt, maker);
			pstmt.setInt(++cnt, price);
			pstmt.setInt(++cnt, num);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(
					count + "개의 행을 수정했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
		
	}
	//자동차 정보 삭제
	public void deleteCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "DELETE FROM car WHERE num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(
					count + "개의 행을 삭제했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}




