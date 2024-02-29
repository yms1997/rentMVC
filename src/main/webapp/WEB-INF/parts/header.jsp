<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="logId" value="${loginId}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/memberLoginandOut.js" defer></script>
</head>
<body>
	<div class="container">
		<header>
			<div class="banner">
				<c:if test="${logId eq 'admin'}">
				<a href="${ctx}/memberList.do">회원목록</a>
				</c:if>
				<c:if test="${log eq null}">
				GUEST님
				<a href="${ctx}/memberInsert.do">회원가입</a>
				<a href="${ctx}/memberLogin.do">로그인</a>
				</c:if>
				<c:if test="${log ne null}">
				${logId}님
				<a href="${ctx}/memberContent.do?no=${log}">내정보</a>
				<a class="logout-btn">로그아웃</a>
				</c:if>
			</div>
			<nav>
				<div class="logo">
					<a href="${ctx}/main.do"><img alt="logo" src="img/logo.jpg" width="300px" height="300px"></a>				
				</div>
				<div class="gnb">
					<a href="${ctx}/rentcarList.do?kind=recent">차량 조회</a>
          			<a href="${ctx}/userReserveList.do"> 내 예약 확인  </a>
          			<a href="${ctx}/registerCar.do"> 차량 등록</a>
				</div>
			</nav>
		</header>
	