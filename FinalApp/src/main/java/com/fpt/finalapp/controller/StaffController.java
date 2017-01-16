package com.fpt.finalapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fpt.finalapp.DAO.NhanVienDAO;
import com.fpt.finalapp.DAO.RoleDAO;
import com.fpt.finalapp.DAO.TaiKhoanDAO;
import com.fpt.finalapp.entities.NhanVien;
import com.fpt.finalapp.entities.NhanVienAll;
import com.fpt.finalapp.entities.Role;
import com.fpt.finalapp.entities.TaiKhoan;
import com.fpt.finalapp.form.ChangePassForm;

@Controller

@Transactional

@EnableWebMvc
public class StaffController {
	@Autowired
	private NhanVienDAO nhanvienDao;
	@Autowired
	private TaiKhoanDAO taikhoanDao;
	@Autowired
	private RoleDAO roleDao;

	@RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
	public String userList(Model model, Principal principal) {

		NhanVienAll nv = new NhanVienAll();
		List<Role> alGroup = roleDao.listG();
		model.addAttribute("nhanviens", nv);
		model.addAttribute("listgroup", alGroup);
		String username = principal.getName();
		return "home";
	}
	
	// Add Staff
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save1(Model model, @ModelAttribute("nhanviens") NhanVienAll nhanvien) {
		int value = nhanvienDao.getlastvalue();
		NhanVien nv = new NhanVien("manv0" + value, nhanvien.getTenNV(), nhanvien.getGioiTinh(), nhanvien.getNgaySinh(),
				nhanvien.getDiaChi(), nhanvien.getDienThoai());
		nhanvienDao.inserData(nv);
		int value2 = taikhoanDao.getlastvalue();
		Role role = new Role();
		role.setIdRole(nhanvien.getIdRole());
		TaiKhoan tk = new TaiKhoan("manv0" + value2, nhanvien.getPassword(), role);
		nhanvien.setMaNV("manv0" + value2);
		taikhoanDao.inserData(tk);	
		return "success";
	}
	// Change Pass
	@RequestMapping(value = "/changepass", method = RequestMethod.POST)
	public String changepass(Model model, @ModelAttribute("changePassForm") ChangePassForm changePassForm, Principal principal){
		String id = principal.getName();
		System.out.println(id);
		TaiKhoan tk = taikhoanDao.getTaiKhoan(id);
		if(changePassForm.getOldPass().equals(tk.getPassword())
				&& changePassForm.getNewPass().equals(changePassForm.getNewPassConfirm())){
			taikhoanDao.changePass(id, changePassForm.getNewPass());
			model.addAttribute("msg2", "doi mat khau thanh cong!");
			return "doimatkhau";
		}
		else{
			if(!(changePassForm.getOldPass().equals(tk.getPassword()))) {
				model.addAttribute("msg", "Ban da nhap sai mat khau!");
			}
			if(!(changePassForm.getNewPass().equals(changePassForm.getNewPassConfirm()))){
				model.addAttribute("msg1", "Mat khau nhap khac nhau!");
			}
		}
		return "doimatkhau";
	}
	@RequestMapping("/back")
	public String returnPage(){
		
		return "success";
	}
}
