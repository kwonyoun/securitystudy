<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot Index</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<body>

	<div class="loginBox01">
	<div class="loginBox_line">
		<form action="/login-process" method="post">
		<div class="loginBox02">
		<div class="logoimg"><a href="#"><img src="mainindeximgs/logo.png"></a></div>
		<div class="form-group">
		<label for="iid">아이디</label>
		<input type="text" name="memId" id="iid" class="form-control"/>
		</div>
		
		<div class="form-group">
		<label for="pw">비밀번호</label>
		<input type="password" name="memPw">
		</div>
		
		<div class="form-group">
		<input type="submit" value="로그인" id="Loginbtn">
		</div>
	<!-- onclick=location.href="tour002.jsp">  -->
	<!-- submit = 지금 이 페이지의 정보를 들고 가겠다, submit이랑 onclick은 같이 쓸 수 없음 -->
		<div class="form-group01">
		<a href="#">아이디찾기</a>
		<a href="#">비밀번호찾기</a>
		</div>
		</div>
		
	</form>
	</div>
	</div>
	<div class="loginBottom">
		<div>
		<a href="#"><img src="mainindeximgs/loginBanner.png"></a></div>
		
		<div class="etcText"><a href="#">이용약관&nbsp;&nbsp;</a>|
		<a href="#">&nbsp;&nbsp;개인정보처리방침&nbsp;&nbsp;</a>|
		<a href="#">&nbsp;&nbsp;책임의 한계와 법적고지&nbsp;&nbsp;</a>|
		<a href="#">&nbsp;&nbsp;고객센터</a></div>
		 
		<div class="bottom">
		<div class="bottomLogo"><a href="#">ittravel</a></div>
		<div class="copy">Copyright © ITTRAVEL Corp. All Rights Reserved.</div>
		</div>
		</div>
	</div>
</body>
</html>