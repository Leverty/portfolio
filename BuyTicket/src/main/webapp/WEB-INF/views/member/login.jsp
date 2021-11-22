<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
<link href="${path}/resources/css/login.css" rel="stylesheet" type="text/css">
<title>Login Page</title>
<link href="${path}/resources/css/topmenu.css" rel="stylesheet" type="text/css">
<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
   
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
   
	<!-- Google CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

	<!-- CSS -->
	<link href="../../resources/css/default.css" rel="stylesheet" type="text/css">
</head>

<body>
<!-- top menu start -->

<%@ include file="../include/topmenu.jsp" %>
<!-- top menu end -->

<!-- login form start -->
<div class="login-page">
	<div class="form">
		<form class="login-form" action="/member/login" method="post">
			<input type="text" placeholder="Id" id="userId" name="userId"/>
			<input type="password" placeholder="Password" id="userPw" name="userPw"/>
			<button type="submit">login</button>
			<p class="message">Not registered? <a href="register">Create an account</a></p>
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>

	<!-- login js function -->
	<script type="text/javascript" src="../../resources/js/login.js"></script>
</body>
</html>