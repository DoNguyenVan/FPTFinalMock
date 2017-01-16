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
 #tittle{
    color: red;
	text-align: center;
 }
 #tk{
  background-color: #ccf5ff;
  border: 1px solid;
 }
 #nv{
   margin-top: 5%;
   border: 1px solid;
   padding: 1%;
 }

table tr td{
  padding:3%;
 }
 #tk{
   margin-top: 15%;
 }
 #footer{
   margin-top: 3%;
   margin-right: 40%;
   display: inline;
 }
</style>

</head>
<body>
 

    <!--  Start Body -->
       
      
	     <h1 id="tittle">Thêm thông tin tài khoản nhân viên</h1>
	     <div class="col-md-12">
	     
	       <div class="col-md-4  col-md-offset-2" id="tk">
	          <form id="tk-form">
	            <table>
	               <tr>
	                 <td><label>Tên Tài Khoản</label></td>
	                 <td><input type="text"/></td>
	               </tr>
	               <tr>
	                 <td>Mật Khẩu</td>
	                 <td><input type="password" /></td>
	               </tr>
	               <tr>
	                 <td>Quyền</td>
	                 <td><select class="form-control">
	                      <option value="Quan Ly" label="Quản Lý" >
	                      <option value="Ke Toan" label="Kế Toán">
	                      <option value="Nhan Vien" label="Nhân Viên">
	                     </select></td>
	               </tr>
	            </table>           
	          </form>
	       </div>
	      
	       <div class="col-md-5" id="nv">	         
	        <div class=" panel-heading  glyphicon glyphicon-user"><strong>  Nhân Viên</strong> </div>
	        <hr>
	         <form>
	           <table>
	             <tr> 
	                <td>Mã Nhân Viên</td>
	                <td><input type="text"/></td>
	             </tr>
	             <tr>
	                <td>Họ Tên</td>
	                <td><input type="text" /></td>
	             </tr>
	             <tr>
	               <td>Giới Tính</td>
	               <td><select class="form-control">
	                     <option value="Nam" label="Nam">
	                     <option value="Nữ" label="Nữ">
	                   </select></td>
	             </tr>
	             <tr>
	                <td>Ngày Sinh</td>
	                <td><input type="text"/></td>
	             </tr>
	             <tr>
	                <td>Địa Chỉ</td>
	                <td><input type="text" /></td>
	             </tr>
	             <tr>
	                <td>Điện Thoại</td>
	                <td><input type="text" /></td>
	             </tr>
	           </table>
	         </form>
	       </div>
	     
	     </div>	
	     
	     
	   	 <div class="row pull-right" id="footer">	
	   	   <div class="row">    	    
			  <div class="col-md-5 "><button class="btn btn-default glyphicon glyphicon-user"> Thêm </button></div>	
			  <div class="col-md-5 col-md-offset-2"><button class="btn btn-default glyphicon glyphicon-share-alt "> Trở về</button></div>
			</div>
	    </div>
  		
</body>
</html>