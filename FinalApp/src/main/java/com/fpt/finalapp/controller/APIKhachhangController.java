package com.fpt.finalapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.finalapp.DAO.KhachhangDAO;
import com.fpt.finalapp.entities.KhachHang;

@Controller
public class APIKhachhangController {

	@Autowired
	private KhachhangDAO khachhangDao;

	

	@RequestMapping(value = "/table_edit_ajax.html", method = RequestMethod.POST)
	@ResponseBody
	public String getEmployeeAPI(HttpServletRequest request, Model model, @RequestBody KhachHang khachhang) {
		
		khachhangDao.editKhach(khachhang);
		return "redirect:/thongtinkhachhang";

	}
	@RequestMapping(value="/table_delete_ajax.html", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestBody List<KhachHang> khachhang2) {
		//String[] list = re
		for (KhachHang khachHang : khachhang2) {
			khachhangDao.deleteKhach(khachHang.getMaKH());
		}
		return "redirect:/thongtinkhachhang";
	}
	
	@ResponseBody
	@RequestMapping("/api/getListKhachhang")
	public List<KhachHang> getListKHByPage(@RequestParam(name="page")Integer page) {
		//System.out.println(employeeService.getAllEmployee(page).size());
		return khachhangDao.getAllKhachhang(page);
	}
	

}
