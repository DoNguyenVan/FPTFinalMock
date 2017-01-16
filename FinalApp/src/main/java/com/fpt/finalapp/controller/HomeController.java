package com.fpt.finalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.finalapp.form.ChangePassForm;

@Controller
public class HomeController {

	@RequestMapping(value={"/","/login"})
	public String showHome() {
		return "login";
	}
	
	@RequestMapping("/themnv")
	public String themNv() {
		return "themnhanvien";
	}
	
	@RequestMapping("/changepassword")
	public String changepw(Model model){
		model.addAttribute("changePassForm", new ChangePassForm());
		return "doimatkhau";
	}
	
	@RequestMapping("/trogiup")
	public String troGiup(){		
		return "trogiup";
	}
	
	@RequestMapping("/quanlyluong")
	public String quanLyLuong(){		
		return "quanlyluong";
	}
	
	
	
}
