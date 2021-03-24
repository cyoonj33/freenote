package com.bitcamp.home.member;

import com.bitcamp.home.DBCPConn;

public class MemberDAO extends DBCPConn {
  public boolean idCheck(String userid) {
	  boolean result = false;   //true 아이디 있다. false:아이디 없다
	  try {
		  sql = "select userid from register where userid=?";
		  
		  getConn();
		  pstmt = con.prepareStatement(sql);
		  pstmt.setString(1,userid);
		  rs=pstmt.executeQuery();
		  if(rs.next()) {
			  result=true;
		  }
		  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }finally {
		  getClose();		  
	  }
	  return result;
  }
}
