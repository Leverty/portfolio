<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true" %>
<html>
<head>
	<link href="../../resources/css/topmenu.css" rel="stylesheet" type="text/css">
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
		@import url('https://fonts.googleapis.com/css2?family=Sonsie+One&display=swap');
	</style>
</head>
<body>
<div class="topmenu">
	
	<div id="header">
		<h1 class="logo">
			<a href="/">Test Logo</a>
		</h1>
		
		<ul class="login">
			<li>
				<c:if test="${user != null}"><p>${user.user_name}님 환영 합니다.</p><a href="/member/logout">로그아웃</a></c:if>
				<c:if test="${user == null}"><a href="/member/login">로그인/회원가입</a></c:if>
			</li>
		</ul>
	</div>
	<div id="nav">
		<ul class="menu">
			<li>
				<a href="/ticketing">예매</a>
			</li>
			<li>
				<a href="/movie">영화</a>
			</li>
			<li>
				<a href="/rank">랭킹</a>
			</li>
			<li>
				<a href="/event">이벤트</a>
			</li>
		</ul>
		
	</div>
	
</div>
</body>
</html>




















