<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="banner">
				<a href="${ctx}/memberList.do">회원목록</a>
				<c:if test="${log eq null}">
				GUEST님
				<a href="${ctx}/memberInsert.do">회원가입</a>
				<a href="${ctx}/memberLogin.do">로그인</a>
				</c:if>
				<c:if test="${log ne null}">
				${loginId}님
				<a href="${ctx}/memberContent.do?no=${log}">내정보</a>
				<a href="${ctx}/memberLogout.do">로그아웃</a>
				</c:if>
			</div>
			<nav>
				<div class="logo">
					<a href="${ctx}/main.do"><img alt="logo" src="img/logo.jpg"></a>				
				</div>
				<div class="gnb">
					
				</div>
			</nav>
		</header>
	