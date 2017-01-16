<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="css/loginpage.css">
</head>

<body>
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="login" method="post">
				<input type="text" placeholder="username" name="username" required="required" /> <input
					type="password" name="password" placeholder="password" required="required" />
				<c:if test="${param.error == 'true'}">
					<div style="color: red; margin: 10px 0px;">

						<h5>username or password not correct</h5>

					</div>
				</c:if>
				<button>login</button>
			</form>
		</div>
	</div>
</body>
</html>
