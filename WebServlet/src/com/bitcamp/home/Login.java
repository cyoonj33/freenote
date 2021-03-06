package com.bitcamp.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login.do")
public class Login extends HttpServlet {
   
    public Login() {
        super();        
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//로그인
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><head><title>로그인</title></head>");
		pw.println("<body>");
		pw.println("<h1>로그인 폼</h1>");
		pw.println("<form method='post' action='login.do'>");
		pw.println("아이디:<input type='text' name='userid'/><br/>");
		pw.println("비밀번호:<input type='password' name='userpwd'/><br/>");
		pw.println("<input type='submit' value='로그인'/></form>");
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//로그인:DB검색 
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			
		
		//1드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//2db연결
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url,"c##scott","tiger");
			//아이디 비번 가져오기
			String userid=request.getParameter("userid");
			String userpwd=request.getParameter("userpwd");
			
			
		//3preparedstatement
		   pstmt = con.prepareStatement("select userid, username from register where userid=? and userpwd=?");
		   pstmt.setString(1, userid);
		   pstmt.setString(2, userpwd);
		   
		//4실행
		   rs = pstmt.executeQuery();
		   //결과 알려줌
		   response.setContentType("text/html; charset=UTF-8");
		   PrintWriter pw = response.getWriter();
		   
		   if(rs.next()) { //로그인 성공시
			   HttpSession session=request.getSession();
			   session.setAttribute("logId", rs.getString(1));
			   session.setAttribute("logName", rs.getString(2));
			   
			   pw.println("<script>alert('로그인 성공하였습니다.');"
					   +"location.href='test.do';"
					   + "</script>");
			   
		   }else {
			   
			   //로그인 실패시
			   pw.println("<script>alert('로그인 실패 하였습니다.');"
					   +"history.back();</script>");
		   }
		   
		//5db닫기
		
		//폼의 정보 가져오기
		//결과 알려줌(client 에게 )
		
		}catch(Exception e) {
			System.out.println("로그인 에러"+e.getMessage());
			
		}finally {
			//DB닫기
			try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
			}catch(Exception ee) {
				System.out.println("db닫기 에러"+ee.getMessage());
			}
		}
	}

}
