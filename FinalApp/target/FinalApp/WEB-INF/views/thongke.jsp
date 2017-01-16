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
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/thongketaichinh.js"></script>
<link rel="stylesheet" type="text/css" href="css/thongketaichinh.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<title>thống kê</title>

</head>
<body>
	<div class="container-fluid">
		<div class="panel panel-success">
		<c:import url="header.jsp"></c:import>

			<div class="panel-body">
				<h1 id="title">Thống kê - Báo cáo</h1>
				<ul class="nav nav-tabs nav-justified">
	 <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'taichinh')" id="defaultOpen">Tài Chính</a></li>
	  <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'vattu')">Vật Tư</a></li>
	  <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'khtn')">Khách Hàng Tiềm Năng</a></li>
					
               </ul>
               <div id="taichinh" class="tabcontent">
					<div class="panel panel-default thongKeTaiChinhPanel" >
						<div class="panel-body bodyTk">
							<div class="col-md-6">
								<h3 class="tbTitle">Bảng thống kê chi tiết</h3>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Hoạt đông</th>
											<th>Trị giá</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Bán hàng</td>
											<td id="banHang">0000</td>
										</tr>
										<tr>
											<td>Nhận từ NCC</td>
											<td id="traHang">0000</td>
										</tr>
										<tr>
											<td>Nhập hàng</td>
											<td id="nhapHang">000</td>
										</tr>
										<tr>
											<td>Trả khách hàng</td>
											<td id="huyHang">000</td>
										</tr>
										
									</tbody>
								</table>
							</div>
							<div class="col-md-6" style="padding-top: 50px;">
								<div class="col-md-offset-2 col-md-2">
									<label>Tháng: </label>
								</div>
								<div class="col-md-4">
									<select class="form-control" id="thang"
										onchange="thongKeTCFunction()">
										<c:forEach var="i" begin="1" end="12">
											<c:if test="${i<10 }">
												<option>0${i}</option>
											</c:if>
											<c:if test="${i>=10 }">
												<option>${i }</option>
											</c:if>

										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-6" style="margin-top: 20px;">
								<div class="col-md-offset-2 col-md-2">
									<label>Năm: </label>
								</div>
								<div class="col-md-4">
									<select class="form-control" id="nam"
										onchange="thongKeTCFunction()">
										<c:forEach var="i" begin="2010" end="2015">
											<option>${i }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<h3 class="tbTitle">Tổng doanh thu</h3>
								<table class="table table-bordered">
									<tbody>
										<tr>
											<td>Tổng thu</td>
											<td id="tongThu">0000</td>
										</tr>
										<tr>
											<td>Tổng chi</td>
											<td id="tongChi">0000</td>
										</tr>
										<tr>
											<td>Doanh thu</td>
											<td id="doanhThu">000</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row pull-right" id="footer">
							<button class="btn btn-default glyphicon glyphicon-print ">
								In</button>
							<button class="btn btn-default glyphicon glyphicon-share-alt ">
								Trở về</button>
						</div>
					</div>
				</div>
	<!-- Thong ke vat tu -->
						<div id="vattu" class="tabcontent">
					  
					  <div class="form-inline col-md-offset-3" style="margin-top: 2%; margin-bottom: 3%;">
					     <div class="form-group"><lable>Từ Ngày :</lable>
					         <input type="date" class="form-control ">    
					      </div>  
					     <div class="form-group col-md-offset-2">
					      </div>  
					
					      <div class="form-group"><lable>Đến Ngày :</lable>
					         <input type="date"  class="form-control"/>
					      </div>
					   </div>
					   
					  <div>
					     <table class="table table-bordered">
					      <thead>
					      <tr>
					        <td>Mã VT</td>
					        <td>Tên VT</td>
					        <td>Vật Tư Nhập</td>
					        <td>Vật Tư Được Bán</td>
					        <td>Vật Tư Tồn Kho</td>
					        <td>Vật Tư Hư Hỏng - Hết Hạn</td>
					       </tr>
					      </thead>
					      <tbody>
					       
					      </tbody>    
					     </table>
					  </div> 
					  
					   <div class="row pull-right" id="footer" style="margin-top: 2%;margin-right: 15%">
					        <button class="btn btn-default glyphicon glyphicon-eye-open"> Xem</button>       
							<button class="btn btn-default glyphicon glyphicon-print "> In</button>
							<button class="btn btn-default glyphicon glyphicon-share-alt "> Trở về</button>
					    </div>
					  
					  
					</div>
				<!--  -->
				
			</div>

		</div>
	</div>
</body>
<script type="text/javascript">
	var myContextPath = "${pageContext.request.contextPath}";
</script>
<script>
	function thongKeTCFunction() {
		var thang = $('#thang').val();
		var nam = $('#nam').val();
		$.ajax({
			type : "GET",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			url : myContextPath + "/api/thongKeTaiChinh?thang=" + thang
					+ '&nam=' + nam,
			success : function(data) {
				$('#banHang').text(data.tongTienBan);
				$('#nhapHang').text(data.tongTienNhap);
				$('#huyHang').text(data.tongTienHuyHang);
				$('#traHang').text(data.tongTienTraHang);
				$('#tongThu').text(data.tongThu);
				$('#tongChi').text(data.tongChi);
				$('#doanhThu').text(data.doanhThu);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}
	$(document).ready(function() {

		thongKeTCFunction();

	});
</script>
<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
$("#defaultOpen").click();
</script>
</html>