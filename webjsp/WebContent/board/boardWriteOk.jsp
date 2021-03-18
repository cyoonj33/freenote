<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.bitcamp.board.BoardDAO" %>

    <!-- 게시판 입력폼에 입력한 데이터를 DB에 저장 -->
    <!-- 폼데이터 request + VO에 담는다 폼의 name속성의 값과 vo에 있는 멤버변수명이 같은 데이터를 담는다.-->
    
    
    <!-- 
    boardVo vo=new BoardVo();    
                        생명주기: request,page,session,application
                        
     객체생성
                       
     -->
 <%
 
 request.setCharacterEncoding("UTF-8");
 
 %>  
 <jsp:useBean id="vo" class="com.bitcamp.board.BoardVO" scope="page" />
 <jsp:setProperty name="vo" property="*" />
 
 <%
 
   //session의 글쓴이 아이디를 vo에 대입한다

   vo.setUserid((String)session.getAttribute("logId"));
 
 //글쓴이 컴 아이피
 
   vo.setIp(request.getRemoteAddr());
 
   BoardDAO dao=new BoardDAO();
   
   int result = dao.insertBoard(vo);
   
   if(result>0){
	   response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
	   
   }else{
	   
	   %>
	   <script>
	      alert("실패");
	      history.back();
	   </script>
	   <% 
   }
   %>
 
