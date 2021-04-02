<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<script src="//cdn.ckeditor.com/4.16.0/full/ckeditor.js"></script> 
<script>
   $(function(){
	   CKEDITOR.replace("content");
   });



</script>
<!-- 

http://commons.apache.org/  다중 업로드
FileUpload, IO를 다운로드

http://commons.apache.org/proper/commons-fileupload/download_fileupload.cgi
commons-fileupload-1.4-bin.zip

https://commons.apache.org/proper/commons-io/download_io.cgi


 -->
 
 <div class="container">
 <br/>
  <h1> 자료실 글올리기(다중업로드) </h1>
  
                                                                                             <!-- 파일업로드일경우 반드시 enctype속성이 있어야 한다 -->
  <form method="post" action="<%=request.getContextPath()%>/data/multiUploadOk.do" id="dataFrm" enctype="multipart/form-data">
  <ul>
     <li>제목 : <input type="text" name="title" id="title" size="50" placeholder="글제목"/><br/></li>
     <li>
         <textarea name="content" id="content"></textarea>     
     </li>
     <!-- 첫번째 첨부파일 : vo.filename1,vo.filename[0] -->
     <li>첨부파일:<input type="file" name="filename" id="filename" multiple/>                     
     <li>           
       <input type="submit" value="자료올리기(다중업로드)"/>
       <input type="reset" value="취소"/>
     </li>
  
  </ul>
  </form>
  
  
</div>