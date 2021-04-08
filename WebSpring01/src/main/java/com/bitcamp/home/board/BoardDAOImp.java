package com.bitcamp.home.board;

import java.util.List;

public interface BoardDAOImp {
    //글 등록
	public int boardInsert(BoardVO vo);
	
	//글 전체 선택
	public List<BoardVO> boardAllRecord();	
	
	//글 선택(1레코드)
	public void boardSelect(BoardVO vo);
	//public BoardVO boardSelect(int no);
	
	//글 수정
	public int boardUpdate(BoardVO vo);
	
	//글 삭제	
	public int boardDelete(BoardVO vo);
		
	//조회수 증가
	public void hitCount(int no);
	
	
}
