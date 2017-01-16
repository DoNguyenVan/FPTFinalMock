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
<title>Quản Lý Store</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/w3.css ">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
<link rel="stylesheet" href="css/header.css">

<style type="text/css">
 
 #tittle{
    color: red;
	text-align: center;
	margin-left: 10%;
 }
 #tk{
  background-color: #ccf5ff;
  border: 1px solid;
  padding: 2%;
 }
 table tr td{
  padding:3%;
 }
 table{
   
 }
#footer{
   margin-top: 3%;
   margin-right: 35%;
   display: inline;
 }

</style>

</head>

<body>
	
<div class="container-fluid">
  <div class="panel panel-success">
       <!-- Header -->
        	 <div class="panel-body">
		 <div id="header">
			  <div>
			     <h2><spring:message   code="label.tittleHeader" /></h2>
			  </div>
			  <div class="row">
			    <div class="col-md-2"><img alt="logo" src="img/logo.jpg" height="82" width="182" ></div>
			    <h3  class="col-md-9 col-sm-offset-1"><spring:message   code="label.storeName" /></h3>
			  </div>
		 </div> 
	</div>  
	  
	<div class="panel-body">
	    
 	    <div class="w3-row">
		
		 <div class="w3-col s3  w3-center">
			<div class="w3-dropdown-hover">
				<button class="w3-btn btn-lg glyphicon glyphicon-blackboard">
					<spring:message   code="label.HeThong" /></button>
				<div class="w3-dropdown-content w3-border">
					 
 
					<div class="dropdown">
					  <button  class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
					  <spring:message   code="label.NgonNgu" /><span class="glyphicon glyphicon-menu-right"></span></button>
					  <div class="dropdown-content">
						<a href="${pageContext.request.contextPath}/home?lang=en" ><spring:message   code="label.TiengAnh" /></a>
					    <a href="${pageContext.request.contextPath}/home?lang=vi" ><spring:message   code="label.TiengViet" /></a>
									  
					  </div>
					</div>
				</div>
			</div>	
		  </div>	
		 
		 <div class="w3-col s3  w3-center">
			<div class="w3-dropdown-hover">
				<button class="w3-btn btn-lg glyphicon glyphicon-oil">
					<spring:message   code="label.DoanhMuc" /></button>
				<div class="w3-dropdown-content w3-border">
					<div class="dropdown">
					  <button  class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
					 <spring:message   code="label.QLTT" /><span class="glyphicon glyphicon-menu-right"></span></button>
					  <div class="dropdown-content">
					    <a href="#"target="iframe"> <spring:message   code="label.TTNV" /></a> 
					     <a href="#" target="iframe"><spring:message   code="label.TTKH" /></a> 
					    <a href="#" target="iframe"><spring:message   code="label.TTVT" /></a>
					  </div>
					</div>
					
					<div class="dropdown">
					  <button  class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
					  <spring:message   code="label.QLK" /><span class="glyphicon glyphicon-menu-right"></span></button>
					  <div class="dropdown-content">
					    <a href="nhapkho" target="iframe"><spring:message   code="label.QLNK" /></a>
					     <a href="#" target="iframe"><spring:message   code="label.QLXK" /></a> 
					  </div>
					</div>					
	
					<a href="quanlyluong" target="iframe"><spring:message   code="label.QLL" /></a>								
				</div>
			</div>
		</div>
		
		<div class="w3-col s3  w3-center">
				<a href="thongke" target="iframe">
				   <button class="w3-btn btn-lg glyphicon glyphicon-list-alt "> <spring:message   code="label.ThongKe" /></button>
				</a>						
		</div>
		
		<div class="w3-col s3  w3-center">
			<a href="trogiup" target="iframe">
				<button class="w3-btn btn-lg glyphicon glyphicon-question-sign "> <spring:message   code="label.TroGiup" /></button>
			</a>	
		</div>
     </div>
     </div>
        
       <!-- End Header -->
      <div class="panel-body">
       <!--  Start Body -->
       <div class="well">
	      <iframe src="<%=request.getContextPath() %>/login" name="iframe" id="iframe"
			style="border: none; width: 100%; height: 685px;"> </iframe>
		</div>	
		<!--  End Body -->	
      </div>
    
    </div>  	    
 </div> 
</body>
</html>

