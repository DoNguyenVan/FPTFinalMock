package com.fpt.finalapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.finalapp.DAO.NhanVienDAO;
import com.fpt.finalapp.entities.NhanVien;

@Controller
public class APINhanvienController {

	@Autowired
	private NhanVienDAO nhanvienDao;

	

	@RequestMapping(value = "/table_edit_nhanvien.html", method = RequestMethod.POST)
	@ResponseBody
	public String getEmployeeAPINhanvien(HttpServletRequest request, Model model, @RequestBody NhanVien nhanvien) {
		NhanVien nvbyMaNV = nhanvienDao.getKHByMaKH(nhanvien.getMaNV());
		NhanVien nv1 = new NhanVien(nhanvien.getMaNV(), nhanvien.getTenNV(), nhanvien.getGioiTinh(), nhanvien.getNgaySinh(), nhanvien.getDiaChi(), nhanvien.getDienThoai(), nvbyMaNV.getLuong(), nvbyMaNV.getTamUng());
		nhanvienDao.editNhanvien(nv1);
		return "redirect:/thongtinnhanvien";

	}
	@RequestMapping(value="/table_delete_nhanvien.html", method = RequestMethod.POST)
	@ResponseBody
	public String deleteNV(@RequestBody List<NhanVien> nhanvien2) {
		//String[] list = re
		for (NhanVien nhanVien : nhanvien2) {
			nhanvienDao.deleteNhan(nhanVien.getMaNV());
			System.out.println("xoa thanh cong");
		}
		return "redirect:/thongtinnhanvien";
	}
	
	
	

}
