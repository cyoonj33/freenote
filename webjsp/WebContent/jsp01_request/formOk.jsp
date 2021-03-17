<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ page import= "java.util.Enumeration" %>    

    <%
    
    request.setCharacterEncoding("UTF-8");
     
    String username=request.getParameter("username");
    
    String tel=request.getParameter("tel");
    String addr=request.getParameter("addr");
    String gender = request.getParameter("gender");
    
    String[] hobby = request.getParameterValues("hobby");
    String[] local = request.getParameterValues("local");
    
    String intro=request.getParameter("intro");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이름: <%=username %><br/>
연락처: <%=tel %><br/>
주소:<%=addr %><br/>
성별: <%=gender %><br/>
관심분야:<%=Arrays.toString(hobby) %>
지역:
<% 
   for(int i=0; i<local.length; i++){
   
		out.write(local[i]+",");  

}
%><br/>
intro : <%=intro %>
<hr/>
<h1>이전페이지 parameter이름을 얻을 수 있다.</h1>
<ol>
<%
     Enumeration<String> e = request.getParameterNames();
  while(e.hasMoreElements()){
	  out.write("<li>"+e.nextElement()+"</li>");
}

%>
</ol>





<ol>
<%
     Enumeration<String> e2 = request.getParameterNames();
     while(e2.hasMoreElements()) {%>

	 <li> <%= e2.nextElement() %> </li>
	 <%
}

%>


</ol>


<ul>


    <li>접속자의 컴퓨터 ip : <%=request.getRemoteAddr() %> </li>
    <li>인코딩 코드값 : <%=request.getCharacterEncoding() %> </li>
   
    <li>전송방식 : <%=request.getMethod() %> </li>
    <li>프로토콜 : <%=request.getProtocol() %></li>
    <li>URL : <%=request.getRequestURL() %> -> /web/jsp01_request/formOk.jsp</li>
    <li>contextPath : <%=request.getContextPath() %> -> /WebJsp</li>
    <li>서버이름 : <%=request.getServerName() %></li>
    <li>port : <%=request.getServerPort() %> </li>   
    <li>절대주소 : <%=request.getServletContext().getRealPath("/img") %>
    
    
</ul>


</body>
</html>