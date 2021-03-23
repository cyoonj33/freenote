<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<%

  //1 db연결
    //context객체 생성
    Context ctx = new InitialContext();
    Context envCtx = (Context)ctx.lookup("java:comp/env");
    //datasource 객체
    DataSource ds = (DataSource)envCtx.lookup("jdbc/myoracle");
    
    ds.getConnection();
    
    Connection conn = ds.getConnection();
    
    String sql ="select no, subject, userid, hit, writedate from board order by no desc";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs=pstmt.executeQuery();

%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<style>
  ul,li{margin:0; padding:0; list-style-type:none}
  li{float:left; height:40px; line-height:40px; width:10%; }
  li:nth-child(5n+2){width:60px;}
  
  .wordCut{white-space:no-wrap; overflow:hidden; text-overflow:eclipsis;}

</style>
</head>
<body>
<div class="container">
   <h1>게시판 목록</h1>
   <ul>   
   
     <li>번호</li>
     <li>제목</li>
     <li>작성자</li>
     <li>조회수</li>
     <li>등록일</li>
     <%while(rs.next()){%>
	     <li><%=rs.getInt(1) %></li>
	     <li class="wordCut"><%=rs.getString(2) %></li>
	     <li><%=rs.getString(3) %></li>
	     <li><%=rs.getInt(4) %></li>
	     <li class="wordCut"><%=rs.getString(5) %></li>
     <%} 
     
     try{ //디비 연결 끝
		     rs.close();
		     pstmt.close();
		     conn.close();
     }catch(Exception e){
    	 
     }
     %>
   </ul>
</div>

</body>
</html>

<!-- 

   DBCP(커넥션풀:DataBase Connection Pool)
   1프레임워크 준비하기
   http://commons.apache.org 에서 다운로드
   1.dbcp
   2.collection
   3.pool
   
   2oracle.com 에서 ojdbc8.jar를 다운로드
   
   3이클립스의 web-inf/lib에 복사, 톰캣의 lib에 복사
   ojdbc8.jar
   dbcp
   collection
   pool
   
   4환경 변수에 classpath작성  
   ojdbc8.jar
   dbcp
   collection
   pool
   
   환경변수 classpath에
   .;%JAVA_HOME%\lib\tools.jar;
	%CATALINA_HOME%\lib\ojdbc8.jar;
	%CATALINA_HOME%\lib\commons-collections4-4.4.jar;
	%CATALINA_HOME%\lib\commons-dbcp2-2.8.0.jar;
	%CATALINA_HOME%\lib\commons-pool2-2.9.0.jar;
	적기
   
   5.
   톰캑 서버의/conf/server.xml의 <GlobalNamingResources> 사이에 추가 <Resource name="UserDatabase" auth="Container"
   <Resource
   name="jdbc/myoracle"
   auth="Container"
   type="javax.sql.DataSource"
   driverClassName="oracle.jdbc.driver.OracleDriver"
   url="jdbc:oracle:thin:@localhost:1521:xe"
   username="c##scott"
   password="tiger"
   maxActive="20"
   maxIdle="10"
   maxWait="-1"/>
   
   6.
   톰캣서버의 conf/context.xml내에 추가하기 <Context>태그 안에 추가
   
   <Context reloadable="true"> 
    <ResourceLink
         global="jdbc/myoracle"
		 name="jdbc/myoracle"
		 type="javax.sql.OracleDataSource"

	/>
	
	
	7.이크립스 세팅
	이클립스에 web-inf/web.xml 파일의 <web-app>태그에 추가
	톰캑에서 web.xml 파일가져오기)
	
    <resource-ref>
       <description>oracle 데이터 소스</description>
       <res-ref-name>jdbc/myoracle</res-ref-name>
       <res-type>javax.sql.DataSource</res-type>
       <res-auth>Container</res-auth>       
    </resource-ref>
    
    8.톰캣서버에 conf/context.xml파일을 복사하여 이클립스의 meta-inf에 복사 추가
    conf/server.xml에 입력된 <Resource>를 복사하여 meta-inf에 context.xml 추가한다.
    
    <Resource
   name="jdbc/myoracle"
   auth="Container"
   type="javax.sql.DataSource"
   driverClassName="oracle.jdbc.driver.OracleDriver"
   url="jdbc:oracle:thin:@localhost:1521:xe"
   username="c##scott"
   password="tiger"
   maxActive="20"
   maxIdle="10"
   maxWait="-1"/>
   를 <ResourceLink>다음에 추가한다
    

 -->
 
 