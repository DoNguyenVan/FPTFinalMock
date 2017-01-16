package com.fpt.finalapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@Transactional
@EnableWebMvc
public class HomeController {

	
	@RequestMapping(value="/thongke")
	public String showThongKe() {
		return "thongke";
	}
	
	
	@RequestMapping(value ="/doimatkhau")
	public String showDoiMatKhau(){
		
		return"doimatkhau";
	}
	
	@RequestMapping(value ="/themnhanvien")
	public String showThemNhanVien(Model model){
				
		return"themnhanvien";
	}
	
	@RequestMapping(value="/trogiup")
	public String showTrogiup(Model model){
		
		return"trogiup";
	}
	
	@RequestMapping(value="/qlnhanvien")
	public String showQLNhanVien(Model model){
		
		return"thongtinnhanvien";
	}
	
	@RequestMapping(value="/qlKhachHang")
	public String showQLKhachHang(Model model){
		
		return"thongtinkhachhang";
	}
	
	
}
