package kr.employee.dao;

import kr.employee.vo.EmployeeVO;
import kr.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {
	/*
	 * 싱글턴 패턴은 생성자를 private으로 지정해서 외부에서 호출할 
	 * 수 없도록 처리하고 static 메서드를 호출해서 객체가 한 번만
	 * 생성되고 생성된 객체를 공유할 수 있도록 처리하는 방식을 의미함
	 */
	private static EmployeeDAO instance = new EmployeeDAO();

	public static EmployeeDAO getInstance(){
		return instance;
	}

	private EmployeeDAO(){}

	//사원 등록
	public void insertEmployee(EmployeeVO vo)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();

			//SQL문
			sql = """
					INSERT INTO semployee (snum,id,name,passwd,salary,job) 
					VALUES (semployee_seq.nextval,?,?,?,?,?)
					""";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, vo.getId());
			pstmt.setString(++cnt, vo.getName());
			pstmt.setString(++cnt, vo.getPasswd());
			pstmt.setInt(++cnt, vo.getSalary());
			pstmt.setString(++cnt, vo.getJob());

			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//사원상세정보
	public EmployeeVO getEmployee(long snum)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO vo = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();

			//SQL문
			sql = "SELECT * FROM semployee WHERE snum=?";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, snum);

			//SQL문 반영하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();

			if(rs.next()){
				vo = new EmployeeVO(); //자바빈 객체 생성
				vo.setSnum(rs.getLong("snum"));
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setSalary(rs.getInt("salary"));
				vo.setJob(rs.getString("job"));
				vo.setReg_date(rs.getDate("reg_date"));
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return vo;
	}
	//아이디 중복 체크, 로그인 체크
	public EmployeeVO checkEmployee(String id)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO vo = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();

			//SQL문
			sql = "SELECT * FROM semployee WHERE id=?";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			//SQL문 반영하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();

			if(rs.next()){
				vo = new EmployeeVO(); //자바빈 객체 생성
				vo.setId(rs.getString("id"));
				vo.setSnum(rs.getLong("snum"));
				vo.setPasswd(rs.getString("passwd"));
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return vo;
	}
	//사원정보 수정
	public void updateEmployee(EmployeeVO vo)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			//SQL문 
			sql = "UPDATE semployee SET name=?,passwd=?,salary=?,job=? WHERE snum=?";
			//PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, vo.getName());
			pstmt.setString(++cnt, vo.getPasswd());
			pstmt.setInt(++cnt, vo.getSalary());
			pstmt.setString(++cnt, vo.getJob());
			pstmt.setLong(++cnt, vo.getSnum());
			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//사원정보 삭제
	public void deleteEmployee(long snum)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			
			sql = "DELETE FROM semployee WHERE snum=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, snum);
			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
