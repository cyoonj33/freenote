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
   
}
