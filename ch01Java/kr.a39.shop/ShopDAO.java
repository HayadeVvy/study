package kr.a39.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class ShopDAO {
	//관리자 상품 등록
	public void insertItem(String item_name,
			               int item_price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO sitem (item_num,"
				+ "item_name,item_price) VALUES ("
				+ "sitem_seq.nextval,?,?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, item_name);
			pstmt.setInt(2, item_price);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(
				count + "개의 상품을 등록했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//관리자/사용자 상품 목록
	//관리자 회원 목록
	public void selectCustomers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM customer ORDER BY cust_date DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			System.out.println("-".repeat(30));
			if(rs.next()) {
				System.out.println(
						"아이디\t이름\t가입일\t\t전화번호\t주소");
				do {
					System.out.print(
							rs.getString("cust_id") + "\t");
					System.out.print(
							rs.getString("cust_name") + "\t");
					System.out.print(
							rs.getDate("cust_date") + "\t");
					System.out.print(
							rs.getString("cust_tel") + "\t");
					System.out.print(
							rs.getString("cust_address") + "\n");
				}while(rs.next());
			}else {
				System.out.println(
						"등록된 회원 정보가 없습니다.");
			}			
			System.out.println("-".repeat(30));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//관리자 구매 목록
	//사용자 아이디 중복 체크
	public int checkId(String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT cust_id FROM customer WHERE cust_id=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, cust_id);
			
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = 1;
			}			
		}catch(Exception e) {
			count = -1;
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}
	//사용자 회원 등록
	public void insertCustomer(String cust_id,
			                   String cust_passwd,
			                   String cust_name,
			                   String cust_address,
			                   String cust_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO customer (cust_id,"
				+ "cust_passwd,cust_name,"
				+ "cust_address,cust_tel) "
				+ "VALUES (?,?,?,?,?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, cust_id);
			pstmt.setString(2, cust_passwd);
			pstmt.setString(3, cust_name);
			pstmt.setString(4, cust_address);
			pstmt.setString(5, cust_tel);
			
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(
					count + "개의 회원 정보를 저장했습니다.");			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//사용자 로그인 체크
	public boolean loginCheck(String cust_id,
			               String cust_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT cust_id FROM customer "
				+ "WHERE cust_id=? AND cust_passwd=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cust_id);
			pstmt.setString(2, cust_passwd);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return flag;
	}
	//사용자 회원 상세
	public void selectDetailCustomer(
			              String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM customer WHERE cust_id=?";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, cust_id);
			
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("-".repeat(30));
			if(rs.next()) {
				System.out.println(
						"아이디:" + rs.getString("cust_id"));
				System.out.println(
						"이름:" + rs.getString("cust_name"));
				System.out.println(
						"주소:" + rs.getString("cust_address"));
				System.out.println(
						"전화번호:" + rs.getString("cust_tel"));
				System.out.println(
						"가입일:" + rs.getString("cust_date"));
			}else {
				System.out.println(
						"검색된 회원 정보가 없습니다.");
			}
			System.out.println("-".repeat(30));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//사용자 상품 구매
	//시용자 구매 내역
}




