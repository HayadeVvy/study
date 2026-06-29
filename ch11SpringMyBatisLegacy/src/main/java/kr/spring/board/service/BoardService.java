package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import kr.spring.board.vo.BoardVO;

public interface BoardService {
	public void insertBoard(BoardVO board);
	public Integer selectBoardCount();
	public List<BoardVO> selectBoardList(
			                   Map<String,Object> map);
	public BoardVO selectBoard(Long num);
	public void updateBoard(BoardVO board);
	public void deleteBoard(Long num);
}




