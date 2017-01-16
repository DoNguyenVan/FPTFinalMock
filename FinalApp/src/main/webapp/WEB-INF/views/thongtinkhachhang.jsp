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
			<c:import url="header.jsp"></c:import>

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
						<h2 style="text-align: center; color: red;">Thông tin khách hàng</h2>
						<br>
						<div style="max-height: 250px; overflow: auto;">
							<table class="table table-bordered" id="dataTable">
								<thead>
									<tr class="info">
										<th align="center">Mã</th>
										<th>Tên khách hàng</th>
										<th>Địa chỉ</th>
										<th>Điện thoại</th>
										<th>Delete</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="khachhang" items="${list}" varStatus="status">




										<tr id="${khachhang.maKH}" class="edit_tr">
											<%-- <td>${status.index+1}</td> --%>

											<td class="edit_td"><span id="maKH_${khachhang.maKH}"
												class="text"> ${khachhang.maKH} </span></td>

											<td class="edit_td"><span
												id="tenkhach_${khachhang.maKH}" class="text">
													${khachhang.tenKH} </span> <input type="text"
												value="${khachhang.tenKH}" class="editbox"
												id="tenkhach_input_${khachhang.maKH}" /></td>

											<td class="edit_td"><span id="diachi_${khachhang.maKH}"
												class="text"> ${khachhang.diaChi} </span> <input type="text"
												value="${khachhang.diaChi}" class="editbox"
												id="diachi_input_${khachhang.maKH}" /></td>

											<td class="edit_td"><span id="phone_${khachhang.maKH}"
												class="text"> ${khachhang.phone} </span> <input type="text"
												value="${khachhang.phone}" class="editbox"
												id="phone_input_${khachhang.maKH}" /></td>


											<td><input type="checkbox" name="Service"
												value="${khachhang.maKH}"></td>

										</tr>
									</c:forEach>
								</tbody>
								<tbody id="tableBody">

								</tbody>
							</table>

						</div>



						<div class="row pull-right" id="footer">
							<button class="btn btn-default glyphicon glyphicon-print "
								type="button" name="btn_delete" onclick="AjaxPostdelete() ">Xóa</button>
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
	$(document).ready(

	function() {
		$(".edit_tr").click(function() {
			var ID = $(this).attr('id');
			console.log(ID);
			$("#tenkhach_" + ID).hide();
			$("#diachi_" + ID).hide();
			$("#phone_" + ID).hide();
			$("#tenkhach_input_" + ID).show();
			$("#diachi_input_" + ID).show();
			$("#phone_input_" + ID).show();

		}).change(function() {
			var ID = $(this).attr('id');
			var tenkhach = $("#tenkhach_input_" + ID).val();
			var diachi = $("#diachi_input_" + ID).val();
			console.log(tenkhach);
			var phone = $("#phone_input_" + ID).val();
			var dataString = {};
			dataString["maKH"] = ID;
			dataString["tenKH"] = tenkhach;
			dataString["diaChi"] = diachi;
			dataString["phone"] = phone;
			$("#first_" + ID).html('<img src="load.gif" />'); // Loading image
			if (tenkhach.length > 0 && diachi.length > 0 && phone.length > 0) {
				$.ajax({
					type : "POST",
					url : "table_edit_ajax.html",
					contentType : 'application/json; charset=utf-8',
					dataType : 'text',
					data : JSON.stringify(dataString),
					/* data : dataString, */
					cache : false,
					success : function(html) {
						$("#tenkhach_" + ID).html(tenkhach);
						$("#diachi_" + ID).html(diachi);
						$("#phone_" + ID).html(phone);
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

		$("#search").click(function() {
			var property = $('#properties').val();
			var keySearch = $('#keySearch').val();
			$.ajax({
				type : "GET",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : myContextPath + "/search?keySearch=" + keySearch,
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