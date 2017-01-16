<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.1.1"></script>
<script type="text/javascript" src="js/thongketaichinh.js"></script>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<title>Tạo tài khoản</title>
<style type="text/css">
#tittle {
	color: red;
	text-align: center;
	margin-left: 10%;
}

#tk {
	background-color: #ccf5ff;
	border: 1px solid;
	padding: 2%;
}

table tr td {
	padding: 3%;
}

table {
	
}

#footer {
	margin-top: 3%;
	margin-right: 35%;
	display: inline;
}
</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<h1 id="tittle">Đổi Mật Khẩu Nhân Viên</h1>
	<form:form class="form-horizontal" modelAttribute="changePassForm"
		action="changepass" method="post">
		<div class="col-md-5  col-md-offset-4" id="tk">

			<table>
				<tr>
					<div class="bg-danger">${msg}</div>
					<td><label>Mật Khẩu Cũ</label></td>
					<td><form:input path="oldPass" required="required"
							type="password" /></td>
				</tr>
				<tr>
					<div class="bg-danger">${msg1}</div>
					<td><label>Mật Khẩu Mới</label></td>
					<td><form:input path="newPass" required="required"
							type="password" /></td>
				</tr>
				<tr>
					<div class="bg-danger">${msg2}</div>
					<td><label>Nhập Lại Mật Khẩu</label></td>
					<td><form:input path="newPassConfirm" required="required"
							type="password" /></td>
				</tr>
			</table>
		</div>

		<div class="row pull-right" id="footer">
			<div class="row">
				<div class="col-md-5 ">
					<a href="changepass">
						<button type="submit" id="doimatkhau"
							class="btn btn-default glyphicon glyphicon-retweet">
							<strong> Đổi Mật Khẩu</strong>
						</button>
					</a>
				</div>
				<div class="col-md-5 col-md-offset-2">
					<a href="${pageContext.request.contextPath}/back">
						<button type="button"
							class="btn btn-default glyphicon glyphicon-share-alt ">
							<strong> Trở về</strong>
						</button>
					</a>
				</div>
			</div>
		</div>
	</form:form>

<!-- <script type="text/javascript">
	$(document).ready(function(){
	
		$("#doimatkhau").click(function(){
			alert("Value: " + $("#test").val());
			});



});
</script> -->
</body>

</html>