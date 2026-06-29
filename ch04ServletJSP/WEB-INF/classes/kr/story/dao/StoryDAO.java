package kr.story.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.story.vo.StoryVO;
import kr.util.DBUtil;

public class StoryDAO {
	//싱글턴 패턴
	private static StoryDAO instance = new StoryDAO();

	public static StoryDAO getInstance(){
		return instance;
	}

	private StoryDAO(){}

	//글 저장
	public void insertStory(StoryVO vo)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();

			//SQL문
			sql = "INSERT INTO story (story_num,title,content,ip,snum) VALUES (story_seq.nextval,?,?,?,?)";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, vo.getTitle());
			pstmt.setString(++cnt, vo.getContent());
			pstmt.setString(++cnt, vo.getIp());
			pstmt.setLong(++cnt, vo.getSnum());

			//SQL문 실행
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//글의 총 갯수
	public int getCount()throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "select count(*) from story";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//SQL문을 실행해서 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}
	//글 목록
	public List<StoryVO> getList(int startRow, int endRow)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StoryVO> list = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = """
					SELECT *
					FROM story
					JOIN semployee USING (snum)
					ORDER BY story_num DESC
					OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
				""";
			//PreparedStatement 객체
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow - 1);//offset 건너뛸 행의 개수 (skip)
			pstmt.setInt(2, endRow - startRow + 1);//fetch 읽어올 행의 개수 (limit)

			//SQL문 실행하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();
			list = new ArrayList<StoryVO>();
			while(rs.next()){
				StoryVO vo = new StoryVO();
				vo.setStory_num(rs.getLong("story_num"));
				vo.setTitle(rs.getString("title"));
				vo.setReg_date(rs.getDate("reg_date"));
				vo.setId(rs.getString("id"));

				//자바빈을 ArrayList에 등록
				list.add(vo);
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return list;
	}
	//글 상세
	public StoryVO getStory(long story_num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StoryVO vo = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM story s JOIN semployee USING(snum) WHERE story_num=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 매칭
			pstmt.setLong(1, story_num);
			//SQL문 반영하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();

			if(rs.next()){
				vo = new StoryVO();
				vo.setStory_num(rs.getLong("story_num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setReg_date(rs.getDate("reg_date"));
				vo.setSnum(rs.getLong("snum"));
				vo.setId(rs.getString("id"));
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return vo;
	}
	//글 수정
	public void update(StoryVO vo)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try{
			//커넥션풀로부터 커넥션을 반환
			conn = DBUtil.getConnection();
			//SQL문 작성
			//name,email,content,ip 변경 가능 story_num으로 식별
			sql = "UPDATE story SET title=?, "
					+ "content=?,ip=? WHERE story_num=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 매칭
			pstmt.setString(++cnt, vo.getTitle());
			pstmt.setString(++cnt, vo.getContent());
			pstmt.setString(++cnt, vo.getIp());
			pstmt.setLong(++cnt, vo.getStory_num());
			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//글 삭제
	public void delete(long story_num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try{
			//커넥션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "DELETE FROM story WHERE story_num=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 값 매칭
			pstmt.setLong(1, story_num);
			//SQL문 반영
			pstmt.executeUpdate();
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			DBUtil.executeClose(null, pstmt, conn);
		}

	}
}




