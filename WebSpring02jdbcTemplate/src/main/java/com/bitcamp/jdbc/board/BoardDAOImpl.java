package com.bitcamp.jdbc.board;

import java.util.List;

public interface BoardDAOImpl {
    //글전체 선택
	public List<BoardVO> boardAllRecord();
	
	//글선택
	public BoardVO boardOneRecord(int no);
	
	//글추가
	public int boardInsertRecord(BoardVO vo);
	
	//글수정
	public int boardUpdateRecord(BoardVO vo);
	
	//글삭제
	public int boardDeleteRecord(int no, String userid);
	
	//조회수 증가
	public void hitCount(int no);
	
}
