<%@page import="java.util.HashMap"%>
<%@page import="com.bitcamp.board.BoardVO"%>
<%@page import="com.bitcamp.board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</head>
<body>
<c:set var="dan" value="${6}" />
<h1>forEach 태그: 반복문</h1>
<!-- for(int a=10; a<20; a++) 
                      시작값 최종값 증가값-->
                   
<c:forEach var="i" begin="2" end="9" step="1">
     ${dan }*${i }=${dan*i }<br/>
     
</c:forEach>


<c:set var="arr" value="<%= new int[]{25,68,2,5,64,32,55,86,49,95,14} %>"/>

<ol>

<c:forEach var="n" items="${arr }">
 <li> [${n }]</li>
</c:forEach>
</ol>

<%

List<BoardVO> list=new ArrayList<BoardVO>();
list.add(new BoardVO(1, "jstl테스트1"));
list.add(new BoardVO(2, "jstl테스트2"));
list.add(new BoardVO(3, "jstl테스트3"));
list.add(new BoardVO(4, "jstl테스트4"));

%>

<ul>
   <c:forEach var="ii" items="<%=list %>">
   <li>${li.no } : ${ii.subject }</li>
   
   </c:forEach>
</ul>

<%
   HashMap<String,String> hm = new HashMap<String,String>();
   hm.put("name","홍길동");
   hm.put("tel","010-1234-1234");
   hm.put("addr","서울시 마포구 백범로");
%>

<ul>

  <c:forEach var="h" items="<%=hm %>">
    <li>key : ${h.key },value : ${h.value }</li>
  </c:forEach>
  
</ul>

</body>
</html>