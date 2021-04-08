<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

    <h1>회원정보수정</h1>
    <form method="post" action="/home/memberEditOk">
       아이디: ${vo.userid}<br/>
       비밀번호:<input type="password" name="userpwd"/><br/>
       이름:${vo.username}<br/>
       연락처:<input type="text" name="tel1" value="${vo.tel1}"/>-
            <input type="text" name="tel2" value="${vo.tel2}"/>-
            <input type="text" name="tel3" value="${vo.tel3}"/><br/>
       이메일:<input type="text" name="emailid" value="${vo.emailid}"/>@<input type="text" name="emaildomain" value="${vo.emaildomain}"/><br/>
       우편번호: <input type="text" name="zipcode" value="${vo.zipcode}"/><br/>
       주소: <input type="text" name="addr" value="${vo.addr}"/><br/>
       상세주소: <input type="text" name="detailaddr" value="${vo.detailaddr}"/><br/>
       
       관심분야:<input type="checkbox" name="interestArr" value="컴퓨터" <c:forEach var="i" items="${vo.interestArr }"><c:if test="${i=='컴퓨터'}">checked</c:if></c:forEach>>컴퓨터 
              <input type="checkbox" name="interestArr" value="쇼핑" <c:forEach var="i" items="${vo.interestArr }"><c:if test="${i=='쇼핑'}">checked</c:if></c:forEach>>쇼핑
              <input type="checkbox" name="interestArr" value="등산" <c:forEach var="i" items="${vo.interestArr }"><c:if test="${i=='등산'}">checked</c:if></c:forEach>>등산
              <input type="checkbox" name="interestArr" value="영화" <c:forEach var="i" items="${vo.interestArr }"><c:if test="${i=='영화'}">checked</c:if></c:forEach>>영화
              <input type="checkbox" name="interestArr" value="자전거" <c:forEach var="i" items="${vo.interestArr }"><c:if test="${i=='자전거'}">checked</c:if></c:forEach>>자전거
              <input type="checkbox" name="interestArr" value="게임" <c:forEach var="i" items="${vo.interestArr }"><c:if test="${i=='게임'}">checked</c:if></c:forEach>>게임
              <input type="checkbox" name="interestArr" value="숨쉬기" <c:forEach var="i" items="${vo.interestArr }"><c:if test="${i=='숨쉬기'}">checked</c:if></c:forEach>>숨쉬기
              
         <input type="submit" value="회원정보 수정하기"/>  
            
    </form>


</div>
<body>

</body>
</html>