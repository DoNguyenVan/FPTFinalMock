<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
<style type="text/css">
<
title>thong tin nhan vien </title> <style type ="text /css">#title h4 {
	padding: 5px;
	background-color: lavender;
	border: 1px solid darkcyan;
}

#scrollContainer {
	padding: 30px;
	margin-left: 0px;
	margin-right: 0px;
	background-color: #c7e0ff;
	max-height: 242;
	overflow: auto;
}

#inputBox {
	max-height: 167px;
}

.tooltip>.tooltip-inner {
	max-width: 100%;
}

.editbox {
	display: none
}

td {
	padding: 5px;
}

.editbox {
	font-size: 14px;
	width: 270px;
	background-color: #ffffcc;
	border: solid 1px #000;
	padding: 4px;
}

.edit_tr:hover {
	background: url(edit.png) right no-repeat #80C8E5;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="panel panel-success">

			<div class="panel-body">
				<div class="panel panel-primary">

					<form class="form-inline">
						<div class="form-group" style="float: right; margin-top: 2px;"
							cellpadding="0px">

							<div class="form-group">

								<input type="text" class="form-control" id="keySearch">
							</div>
							<div class="form-group">
								<button id="search" type="button" class="btn btn-default">Search</button>
							</div>
						</div>
					</form>
					<div class="panel-body">
						<h2 style="text-align: center; color: red;">Thông tin nhân
							viên</h2>
						<br>
						<div style="max-height: 250px; overflow: auto;">
							<table class="table table-bordered" id="dataTable">
								<thead>
									<tr class="info">
										<th align="center">Mã NV</th>
										<th>Họ tên</th>
										<th>Ngay sinh</th>
										<th>Giới tính</th>
										<th>Địa chỉ</th>
										<th>Điện thoại</th>
										<th>Delete</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="nhanvien" items="${list}" varStatus="status">



										<tr id="${nhanvien.maNV}" class="edit_tr">

											<td class="edit_td"><span id="maNV_${nhanvien.maNV}"
												class="text"> ${nhanvien.maNV} </span></td>

											<td class="edit_td"><span id="tenNV_${nhanvien.maNV}"
												class="text"> ${nhanvien.tenNV} </span> <input type="text"
												value="${nhanvien.tenNV}" class="editbox"
												id="tenNV_input_${nhanvien.maNV}" /></td>

											<td class="edit_td"><span id="ngaysinh_${nhanvien.maNV}"
												class="text"> ${nhanvien.ngaySinh} </span> <input
												type="text" value="${nhanvien.ngaySinh}" class="editbox"
												id="ngaysinh_input_${nhanvien.maNV}" /></td>

											<td class="edit_td"><span id="gioitinh_${nhanvien.maNV}"
												class="text"> ${nhanvien.gioiTinh} </span> <input
												type="text" value="${nhanvien.gioiTinh}" class="editbox"
												id="gioitinh_input_${nhanvien.maNV}" /></td>

											<td class="edit_td"><span id="diachi_${nhanvien.maNV}"
												class="text"> ${nhanvien.diaChi} </span> <input type="text"
												value="${nhanvien.diaChi}" class="editbox"
												id="diachi_input_${nhanvien.maNV}" /></td>

											<td class="edit_td"><span id="phone_${nhanvien.maNV}"
												class="text"> ${nhanvien.dienThoai} </span> <input
												type="text" value="${nhanvien.dienThoai}" class="editbox"
												id="phone_input_${nhanvien.maNV}" /></td>


											<td><input type="checkbox" name="Service"
												value="${nhanvien.maNV}"></td>

										</tr>
									</c:forEach>
								</tbody>
								<tbody id="tableBody">

								</tbody>
							</table>

						</div>



						<div class="row pull-right" id="footer">
							<button class="btn btn-default glyphicon glyphicon-print "
								type="button" name="btn_delete" onclick="AjaxPostdelete() ">Xoa</button>
							<button class="btn btn-default glyphicon glyphicon-share-alt ">
								Trở về</button>
						</div>

					</div>
				</div>

			</div>

		</div>
	</div>
</body>

<script type="text/javascript">
	$(document)
			.ready(

					function() {
						$(".edit_tr")
								.click(function() {
									var ID = $(this).attr('id');
									console.log(ID);
									$("#tenNV_" + ID).hide();
									$("#ngaysinh_" + ID).hide();
									$("#gioitinh_" + ID).hide();
									$("#diachi_" + ID).hide();
									$("#phone_" + ID).hide();
									$("#tenNV_input_" + ID).show();
									$("#ngaysinh_input_" + ID).show();
									$("#gioitinh_input_" + ID).show();
									$("#diachi_input_" + ID).show();
									$("#phone_input_" + ID).show();

								})
								.change(
										function() {
											var ID = $(this).attr('id');
											var tennhanvien = $(
													"#tenNV_input_" + ID).val();
											var ngaysinh = $(
													"#ngaysinh_input_" + ID)
													.val();
											var gioitinh = $(
													"#gioitinh_input_" + ID)
													.val();
											var diachi = $(
													"#diachi_input_" + ID)
													.val();
											var dienthoai = $(
													"#phone_input_" + ID).val();
											/* console.log(tenkhach); */
											var dataString = {};
											dataString["maNV"] = ID;
											dataString["tenNV"] = tennhanvien;
											dataString["ngaySinh"] = ngaysinh;
											dataString["gioiTinh"] = gioitinh;
											dataString["diaChi"] = diachi;
											dataString["dienThoai"] = dienthoai;
											$("#first_" + ID).html(
													'<img src="load.gif" />'); // Loading image
											if (tennhanvien.length > 0
													&& ngaysinh.length > 0
													&& gioitinh.length > 0
													&& diachi.length > 0
													&& dienthoai.length > 0) {
												$
														.ajax({
															type : "POST",
															url : "table_edit_nhanvien.html",
															contentType : 'application/json; charset=utf-8',
															dataType : 'text',
															data : JSON
																	.stringify(dataString),
															/* data : dataString, */
															cache : false,
															success : function(
																	html) {
																$(
																		"#tenNV_input_"
																				+ ID)
																		.html(
																				tennhanvien);
																$(
																		"#ngaysinh_input_"
																				+ ID)
																		.html(
																				ngaysinh);
																$(
																		"#gioitinh_input_"
																				+ ID)
																		.html(
																				gioitinh);
																$(
																		"#diachi_input_"
																				+ ID)
																		.html(
																				diachi);
																$(
																		"#phone_input_"
																				+ ID)
																		.html(
																				dienthoai);
															}
														});
											} else {
												alert('Enter something.');
											}
										});
						// Edit input box click action
						$(".editbox").mouseup(function() {
							return false
						});
						// Outside click action
						$(document).mouseup(function() {
							$(".editbox").hide();
							$(".text").show();
						});

						$("#search")
								.click(
										function() {
											var property = $('#properties')
													.val();
											var keySearch = $('#keySearch')
													.val();
											$
													.ajax({
														type : "GET",
														contentType : 'application/json; charset=utf-8',
														dataType : 'json',
														url : myContextPath
																+ "/search?keySearch="
																+ keySearch,
														success : function(data) {

														},
														done : function(e) {
															console.log("DONE");
														}
													});
										});
					});
	$(document)
			.ready(
					function() {
						$
								.ajax({
									type : "GET",
									contentType : 'application/json; charset=utf-8',
									dataType : 'json',
									url : myContextPath
											+ "/api/getListKhachhang?page=1",
									success : function(data) {
										for (i = 0; i < data.length; i++) {
											$('#tableBody')
													.append(
															'<tr>'
																	+ '<td>'
																	+ (i + 1)
																	+ '</td>'
																	+ '<td>'
																	+ data[i].maKH
																	+ '</td>'
																	+ '<td>'
																	+ data[i].tenKH
																	+ '</td>'
																	+ '<td>'
																	+ data[i].diaChi
																	+ '</td>'
																	+ '<td><a class="btn btn-default edit" style="margin-right: 5px;"><span class="glyphicon glyphicon-pencil"></a><a class="delete btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a></td></tr>');
										}

									},
									done : function(e) {
										console.log("DONE");
									}
								});
						$('#1').attr('class', 'active');
						$('#prev').attr('disabled', 'disabled');
					});
</script>
<script type="text/javascript">
	function AjaxPostdelete() {
		alert("Ban co muon xoa khong?");
		var idServiceObjs = $("input[name='Service']:checked");
		var idServices = [];
		for (var i = 0; i < idServiceObjs.length; i++) {
			idServices.push({
				"maKH" : idServiceObjs[i].value
			});
		}
		console.log(idServices[0]);
		/* var idClient = $('#idClient').val(); */
		$.ajax({
			type : "POST",
			url : "table_delete_ajax.html",
			dataType : "text",
			data : JSON.stringify(idServices),
			contentType : "application/json",
			cache : false,
			success : function(response) {
				console.log(response);
				for (var i = 0; i < idServiceObjs.length; i++) {
					$(idServiceObjs[i]).parent().parent().remove(0);
				}
			},
			error : function(e) {
				console.log(e);
				location.reload(true);
			}
		})
	}
</script>
</html>