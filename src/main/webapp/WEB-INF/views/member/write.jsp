<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function idCheck() {
		var run = true;
		if ($("input[name=id]").val() == '') {
			alert('아이디를 입력하세요');
		} else {
			$.ajax({
				url:'idCheck.do?id='+$("input[name=id]").val(),
				async:false,
				success : function(res) {
					console.log(res);
					if (res != '0') {
						alert('중복된 아이디 입니다.');
						$("input[name=id]").val('');
						run = false;
					}
				}
			})
		}
		if (run) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
<h1>회원 등록</h1>
<form action="insert.do" method="post" enctype="multipart/form-data" onsubmit="return idCheck()">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pwd"><br>
이름 : <input type="text" name="name"><br>
취미 : <input type="checkbox" name="hobbyname" value="영화"> 영화
<input type="checkbox" name="hobbyname" value="독서"> 독서
<input type="checkbox" name="hobbyname" value="게임"> 게임<br>
<input type="file" name="profile"><br>
<input type="submit" value="등록"><br>
</form>
</body>
</html>