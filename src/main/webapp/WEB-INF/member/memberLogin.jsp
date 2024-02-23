<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${ctx}/memberLogin.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td><input class="col-12" type="text" name="id" required /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input class="col-12" type="password" name="pw" required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인"
					class="col-3 btn btn-primary" /></td>
			</tr>
		</table>
	</form>
</body>
</html>