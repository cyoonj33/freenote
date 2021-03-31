package com.bitcamp.home.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcamp.home.CommandService;

public class WriteOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession ses = req.getSession();
	    String sesUserid = (String)ses.getAttribute("userid");
	    String viewFilename="";
	   
	    
	      if(sesUserid!=null && !sesUserid.equals("")) {
	    	  System.out.println(sesUserid+"kk");
	     
				req.setCharacterEncoding("UTF-8");
			  //글등록
				BoardVO vo=new BoardVO();
				vo.setSubject(req.getParameter("subject")); //제목
				vo.setContent(req.getParameter("content"));//글내용
				
				vo.setUserid(sesUserid);
				vo.setIp(req.getRemoteAddr());//글쓴이 아이피
				
				//db
				BoardDAO dao = new BoardDAO();
				int cnt = dao.oneRecordInsert(vo);
				
				req.setAttribute("cnt", cnt);
				
                 //글쓴이
				//글쓴이의 아이피
			  viewFilename = "/board/writeOk.jsp";
			  
			  
	      }else {
	    	  viewFilename = "/member/login.jsp";
	    	  
	    	  
	      }
		
		
		return viewFilename;
		
	}

}
