<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function(){
    	$.ajax({
        	url:'http://localhost:8090/test/api/index6',
	        //dataType:'json',
	        success:function(data) {
	            console.log(data.items);
	            $.each(data.items, (i,e)=>{
	            	console.log(e.PRODUCT_NAME);
	            	$("body").append(e.PRODUCT_NAME+"<br>");
	            })
	        }
     	})
    });
</script>
</head>
<body>

</body>
</html>