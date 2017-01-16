package com.fpt.finalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.finalapp.DAO.NhanVienDAO;
import com.fpt.finalapp.entities.NhanVien;

@Controller
public class NhanvienController {

	@Autowired
	private NhanVienDAO nvienDao;

	@RequestMapping(value = "/thongtinnhanvien")
	public String listNhanvien(Model model, @RequestParam(name = "id", required = false) String id) {

		List<NhanVien> list = nvienDao.getListNhanVien();
		//KhachHang kh = new KhachHang();
		model.addAttribute("list", list);
	
		return "thongtinnhanvien";
	}

	


}
