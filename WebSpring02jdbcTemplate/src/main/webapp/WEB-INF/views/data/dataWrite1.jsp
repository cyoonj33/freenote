<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
   <h1>파일업로드1</h1>
   
   <form method="post" action="/jdbc/upload1" enctype="multipart/form-data">
   <input type="text" name="title" style="width:800px;"/><br/>
   <textarea name="content" style="width:800px; height:300px;" ></textarea></br>
   
   첨부파일:<input type="file" name="filename1"/>
          <input type="file" name="filename2"/><br/>
          
          <input type="submit" value="업로드"/>
   </form>


</div>

</body>
</html>