<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
}

#tk {
	background-color: #ccf5ff;
	border: 1px solid;
}

#nv {
	margin-top: 5%;
	border: 1px solid;
	padding: 1%;
}

table tr td {
	padding: 3%;
	width: 120px;
	'
}

#tk {
	margin-top: 15%;
}

#footer {
	margin-top: 3%;
	margin-right: 40%;
	display: inline;
}
</style>

</head>
<body>

			<div class="panel-body">
				<h1 id="tittle">Thêm thông tin tài khoản nhân viên</h1>
				<form:form class="form-horizontal" modelAttribute="nhanviens"
					action="save" method="post">
					<div class="col-md-12">

						<div class="col-md-4  col-md-offset-2" id="tk">



							<table>
								<tr>
									<td>Mã Nhân Viên</td>
									<td><form:input path="maNV" type="text"
											required="required" readonly="true" cssClass="form-control" /></td>
								</tr>
								<tr>
									<td>Mật Khẩu</td>
									<td><form:input type="password" required="required"
											path="password" /></td>
								</tr>
								<tr>
									<td>Quyền</td>
									<td><select class="form-control" required="required"
										name="idRole">
											<c:forEach var="gr" items="${listgroup }">
												<c:choose>
													<c:when test="${gr.idRole==nv.idRole }">
														<option value="${gr.idRole }" selected="selected">${gr.nameRole }</option>
													</c:when>
													<c:otherwise>
														<option value="${gr.idRole }">${gr.nameRole}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>
								</tr>
							</table>
						</div>

						<div class="col-md-5" id="nv">
							<div class=" panel-heading  glyphicon glyphicon-user">
								<strong> Nhân Viên</strong>
							</div>
							<hr>
							<table>
								<tr>
									<td>Họ Tên</td>
									<td><form:input path="tenNV" type="text"
											required="required" placeholder="Example: Nguyễn Văn A" /></td>
								</tr>
								<tr>
									<td>Giới Tính</td>
									<td><form:select class="form-control" path="gioiTinh"
											required="required">
											<option value="nam" label="Nam">
											<option value="nu" label="Nữ">
											<option value="khac" label="Khác">
										</form:select></td>
								</tr>
								<tr>
									<td>Ngày Sinh</td>
									<td><form:input path="ngaySinh" type="text"
											required="required" placeholder="Example: 2002 - 02 - 02" /></td>
								</tr>
								<tr>
									<td>Địa Chỉ</td>
									<td><form:input path="diaChi" type="text"
											required="required" placeholder="Example: 2002 - 02 - 02" /></td>
								</tr>
								<tr>
									<td>Điện Thoại</td>
									<td><form:input path="dienThoai" type="text"
											required="required" placeholder="Example: 0911.111.111" /></td>
								</tr>
							</table>
						</div>
						<div class="row pull-right" id="footer">
							<div class="row">
								<div class="col-md-5 ">
									<button type="submit"
										class="btn btn-default glyphicon glyphicon-user">Thêm</button>
									<div class="bg-danger">
										<span>${msg}</span>
									</div>
								</div>
								<div class="col-md-5 col-md-offset-2">
									<a href="${pageContext.request.contextPath}/back">
										<button class="btn btn-default glyphicon glyphicon-share-alt " type="button">
											Trở về</button>
									</a>
								</div>
							</div>
						</div>
				</form:form>

			</div>

</body>
</html>