
<!-- 지시부 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar,java.util.Scanner" %>
<%@ page import="java.util.Random" %>
<%@ page trimDirectiveWhitespaces="true" %> <!-- jsp코드 빈자리 제거 -->



<%!

     //선언부
     //메소드 또는 변수 선언
     
			public int sum(int a, int b){
				int hap = a+b;
				return hap;
			}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        h1{ background-color:pink;}

</style>
<script>

       //document.write("javascript..")
       
</script>
</head>
<body>
<h2>session,ID : <%=session.getId() %></h2>

<% //세션 로그인 여부를 확인후 선택하여 표시한다.

    if(session.getAttribute("logStatus")==null){//로그인 안됨
%>

		<a href="<%=request.getContextPath()%>/loginPage/login.html">로그인</a>
 <%   }else if(session.getAttribute("logStatus").equals("Y")){ %>
 
 
		 <%= session.getAttribute("logName") %>
		<a href="<%=request.getContextPath() %>/loginPage/logout.jsp">로그아웃</a>

 <%   } %>
 
   
<h1>jsp start...</h1>

    <%
    
       Calendar now = Calendar.getInstance();
       int year = now.get(Calendar.YEAR);
       int month = now.get(Calendar.MONTH)+1;
       int day = now.get(Calendar.DAY_OF_MONTH);

    %>
    
    <h1>오늘은 <%=year %>년    <%=month %>월     <%=day %>일입니다. </h1>
    <hr/>
    
	<%  //스크립트릿
			
			int a=123; 
	        int b=5678;	        
			String name="홍길동";
			//out내장객체 : client에게 정보를 보냄(response)
			
			out.write(name);			
			int result = sum(a,b);
			out.write("result="+result);
			out.write("<br/>"+a+"+"+"b"+"="+sum(a,b));
	
	%>
	
	<br/>
	<%= a+4 %>-
	<%=b %>=
	<%=sum(a,b) %>
	
	
<hr/>
 <%
 
    out.write("<h1>aaaaa</h1>");
    out.write("<img src='img/07.jfif'>");
 %>	
 
</body>
</html>