<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<style>
   #dataList{overflow:auto;}
   
   #dataList>li{
    float:left; width:10%; height:40px; line-height:40px; border-bottom:1px solid #ddd;
   }
   
   #dataList>li:nth-child(7n+2){width:40%}

</style>

<div class="container">
    <h1>자료실 리스트</h1>
    <div>
    
    <c:if test="${userid!=null || userid!=''}">
    <a href="<%=request.getContextPath()%>/data/dataForm.do">자료실 글올리기</a>
    </c:if>
    
    </div>
    <ul id="dataList">
       <li>번호</li>      
       <li>제목</li>  
       <li>글쓴이</li>   
       <li>hit</li>  
       <li>첨부</li>  
       <li>다운횟수</li>
       <li>등록일</li>     
       
      
      <c:forEach var="dataVO" items="${lst}">
      
       <li>122</li>      
       <li>제목dd</li>  
       <li>글쓴이</li>   
       <li>5</li>  
       <li>
         <img src="<%=request.getContextPath()%>/img/disk.png" title="파일명1"/>
          <img src="<%=request.getContextPath()%>/img/disk.png" title="파일명2"/>
       </li> 
       <li>6</li>
       <li>21-03 01:01</li>
       
       </c:forEach> 
    </ul>
</div>