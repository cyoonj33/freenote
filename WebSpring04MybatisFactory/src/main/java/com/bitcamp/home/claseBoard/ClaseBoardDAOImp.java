package com.bitcamp.home.claseBoard;

import java.util.List;



public interface ClaseBoardDAOImp {
   public int claseInsert(ClaseBoardDTO dto);  
   public List<ClaseBoardDTO> claseAllRecord();
   public ClaseBoardDTO claseSelect(int no);
   public int hitCount(int no);
   public ClaseBoardDTO oriInfor(int no);//원글의 ref,step,lvl 을 선택
   public int lvlCount(ClaseBoardDTO dto);//lvl증가
   public int claseDataInsert(ClaseBoardDTO dto);
   public int getTotalRecord(); //총레코드수 구하기
   public int claseUpdate(ClaseBoardDTO dto);
   public ClaseBoardDTO getStep(int no);//스탭과 유저아이디 가져오기
   public int claseDelete(int no);//원글삭제
   public int claseDeleteUpdate(int no,String userid);//답글삭제
   public List<ClaseBoardDTO> nextListRecord();//다음글리스트
}
