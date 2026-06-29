package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.board.vo.BoardVO;
import kr.util.DBUtil;
import kr.util.StringUtil;

public class BoardDAO {
	//싱글턴 패턴
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {}
	
	//글 저장
	public void insert(BoardVO boardVO)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			//커넥션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = """
					INSERT 
					INTO svboard (num,title,name,passwd,
					              email,content,ip,filename)
					VALUES (svboard_seq.nextval,?,?,?,?,?,?,?)
					""";
			//PreParedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(++cnt, boardVO.getTitle());
			pstmt.setString(++cnt, boardVO.getName());
			pstmt.setString(++cnt, boardVO.getPasswd());
			pstmt.setString(++cnt, boardVO.getEmail());
			pstmt.setString(++cnt, boardVO.getContent());
			pstmt.setString(++cnt, boardVO.getIp());
			pstmt.setString(++cnt, boardVO.getFilename());
			//SQL문 실행
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//글의 총개수
	public int getCount()throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//커넥션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT COUNT(*) FROM svboard";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//SQL문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}		
		return count;
	}
	//글 목록
	public List<BoardVO> getList(int startRow,int endRow)
	                                 throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = null;
		String sql = null;
		
		try {
			//커넥션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = """
					SELECT *
					FROM svboard
					ORDER BY num DESC
					OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
					""";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow - 1);//건너뛰는 개수
			pstmt.setInt(2, endRow - startRow + 1);//읽어올 개수
			//SQL문 실행
			rs = pstmt.executeQuery();
			list = new ArrayList<BoardVO>();
			while(rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setNum(rs.getLong("num"));
				//HTML를 허용하지 않음
				boardVO.setTitle(StringUtil.useNoHtml(
						           rs.getString("title")));
				boardVO.setName(rs.getString("name"));
				boardVO.setReg_date(rs.getDate("reg_date"));
				
				//자바빈(DTO)을 ArrayList에 저장
				list.add(boardVO);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}		
		return list;
	}
	//글 상세
	public BoardVO getBoard(long num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
		String sql = null;
		
		try {
			//커넥션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM svboard WHERE num=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setLong(1,num);
			//SQL문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setNum(rs.getLong("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				//수정,삭제시 비밀번호 필요
				board.setPasswd(rs.getString("passwd"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setFilename(rs.getString("filename"));
				board.setReg_date(rs.getDate("reg_date"));
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}		
		return board;
	}
	//글 수정
	public void update(BoardVO boardVO)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0;
		
		try {
			//커넥션풀로부터 커넥션 반환
			conn = DBUtil.getConnection();
			
			if(boardVO.getFilename()!=null 
					 && !boardVO.getFilename().isEmpty()) {
				sub_sql += ",filename=?";
			}
			
			//SQL문 작성
			sql = "UPDATE svboard SET title=?,name=?,email=?,content=?,ip=?" + sub_sql + " WHERE num=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(++cnt, boardVO.getTitle());
			pstmt.setString(++cnt, boardVO.getName());
			pstmt.setString(++cnt, boardVO.getEmail());
			pstmt.setString(++cnt, boardVO.getContent());
			pstmt.setString(++cnt, boardVO.getIp());
			if(boardVO.getFilename()!=null 
					 && !boardVO.getFilename().isEmpty()) {
				pstmt.setString(++cnt, boardVO.getFilename());
			}
			pstmt.setLong(++cnt, boardVO.getNum());
			//SQL문 실행
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//글 삭제
	public void delete(long num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//커멕션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "DELETE FROM svboard WHERE num=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setLong(1, num);
			//SQL문 실행
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}






