<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/w3.css ">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
<style type="text/css">
#header .row{
  background-color: green;
  padding:1%;
  margin-left:0.5px;
  margin-right: 0.5px; 
}
#header h3{
  color: white;
}
#header {
 margin-top:1%;
 display: block;
 padding: 5px;
 border-color: gray;
}
.panel-body{
 border: 2px solid;
 border-color: gray; 
}
</style>

</head>

<body>

	 <div class="panel-body">
		 <div id="header">
			  <div>
			     <h2>Quản Lý Cửa Hàng Bán Vật Tư Y Tế</h2>     
			  </div>
			  <div class="row">
			    <div class="col-md-2"><img alt="logo" src="img/logo.jpg" height="82" width="182" ></div>
			    <h3  class="col-md-9 col-sm-offset-1">STORE MEDICAL SUPPLIES</h3>
			  </div>
		 </div> 
	</div>  
	  
	<div class="panel-body">
	    
 	    <div class="w3-row">
		
		 <div class="w3-col s3  w3-center">
			<div class="w3-dropdown-hover">
				<button class="w3-btn btn-lg glyphicon glyphicon-blackboard">
					Hệ Thống</button>
				<div class="w3-dropdown-content w3-border">
					 <a href="#">Tạo Tài Khoản</a> 
					 <a href="#">Đổi Mật Khẩu</a> 
					 <div class="w3-dropdown-hover""><button class="w3-btn">
					Ngôn Ngữ</button>
					<div class="w3-dropdown-content w3-border">
					 <a href="#">Tạo Tài Khoản</a> 
					 <a href="#">Đổi Mật Khẩu</a> 
					</div>
					</div>
				</div>
			</div>	
		  </div>	
		 
		 <div class="w3-col s3  w3-center">
			<div class="w3-dropdown-hover">
				<button class="w3-btn btn-lg glyphicon glyphicon-oil">
					Danh mục</button>
				<div class="w3-dropdown-content w3-border">
					<a href="#">Quản Lý Thông Tin</a> 
					<a href="#">Quản Lý Kho</a> 
					<a href="#">Quản Lý Lương</a>								
				</div>
			</div>
		</div>
		
		<div class="w3-col s3  w3-center">
				<a href="${pageContext.request.contextPath}/thongke">
				   <button class="w3-btn btn-lg glyphicon glyphicon-list-alt "> Thống Kê</button>
				</a>						
		</div>
		
		<div class="w3-col s3  w3-center">
			<div class="w3-dropdown-hover">
				<button class="w3-btn btn-lg glyphicon glyphicon-question-sign "> Trợ giúp</button>
			</div>
		</div>
     </div>
 
 </div>  	    
     
</body>
</html>

