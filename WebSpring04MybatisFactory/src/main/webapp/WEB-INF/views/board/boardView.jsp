<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script>
    function boardDel(no){
    	
    	if(confirm("삭제하시겠습니까?")){
    		location.href="boardDel?no=${vo.no}";
    		
    	}
    	
    }
    
    
    $(function reply(){
    	$('#replyWriteBtn').click(function(){
    	if($('#replycontent').val()!=''){
    	var url = '/reply/replyWriteOk';
    	var params = $('#replyWriteFrm').serialize();
    	$.ajax({
    	url:url,
    	data:params,
    	success:function(result){
    	console.log("성공"+result);
    	$('#replycontent').val('');
    	replyList();
    	},error: function(){
    	
    	alert("댓글등록실패");
    	
    	}
    	})
    	}else{
    	alert("댓글을 입력해주세요");
    	}
    	});
    });

    		function replyList(){
    			
    			var url= "/reply/replyList";
    			var params= "no=${vo.no}";

    			$.ajax({
    				url:url,
    				data:params,
    				success:function(result){
    					var $result = $(result); 
    					
    					var tag="<ul>";
    					$result.each(function(idx, obj){
    						tag += "<li style='border-bottom:1px solid #ddd'><div>"+obj.userid+"("+obj.replydate+")";
    						
    						if(obj.userid=="${logId}"){											
    						tag += "<input type='button' value='수정'/>";
    						tag += "<input type='button' value='삭제' title='"+obj.num+"'/>";		
    						
    						
    						}
    						
    						tag += "<br/>"+obj.content+"</div>";
    						  
    						 if(obj.userid=="${logId}"){
    							 //수정폼
    							 tag +="<div style='display:none'>";
    							 tag +="<form method='post'>"
    							 tag +="<textarea name='replycontent' style='width:300px;height:80px;'>"+obj.content+"</textarea>";
    							 tag +="<input type='submit' value='수정하기'/>";
    							 tag +="<input type='hidden' name='num' value='"+obj.num+"'/>";
    							 tag +="</form></div>";
    							 
    						 }
    						
    						
    						tag += "</li>";
    						
    					});
    					
    					tag +="</ul>";
    					$("#replyList").html(tag);
    					
    				},error:function(){
    					console.log('데이터 가져오기 에러..');
    					
    				}
    			});
    		}
    	
    	
</script>

</head>
<body>
<div class="container">
  <h1>글내용보기</h1>
  번호:${vo.no }<br/>
  작성자 : ${vo.userid }<br/>
  작성일 : ${vo.writedate },조회수 : ${vo.hit }<br/>
  제목 : ${vo.subject }<br/>
  글내용 : ${vo.content }<br/>
  
  <c:if test="${logId==vo.userid }">
   <a href="boardEdit?no=${vo.no }">수정</a>
   <a href="javascript:boardDel(${vo.no })">삭제</a>
  </c:if>
  


<div>


<form method="post" id="replyWriteFrm">
<input type="hidden" name="no" value="${vo.no}">
  <textarea id="replyContent" name="replyContent" style="width:400px; height: 100px;"></textarea>
<input type="button" value="댓글등록" id="replyWriteBtn"> 
</form>

</div>


<div id="replyList">

</div>
</div>

</body>
</html>