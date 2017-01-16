package com.fpt.finalapp.controller;

import java.security.Principal;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
import com.fpt.finalapp.entities.Role;
import com.fpt.finalapp.entities.TaiKhoan;
import com.fpt.finalapp.form.ChangePassForm;
import com.nimbusds.oauth2.sdk.ParseException;

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
	
	// Add Staff
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save1(Model model, @RequestParam("maNV")String maNV,@RequestParam("password")String pass,
			@RequestParam("idRole")String idRole,@RequestParam("tenNV")String tenNV,@RequestParam("gioiTinh")String gioitinh,
			@RequestParam("ngaySinh")String ngaysinh,@RequestParam("diaChi")String diachi,@RequestParam("dienThoai")String dienthoai
			) throws ParseException {
		
//	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//	    Date date = null;
//	    try {
//
//            date = (Date) formatter.parse(ngaysinh);
//        } catch (java.text.ParseException e) {
//        	e.printStackTrace();
//        	return "redirect:/themnhanvien";
//		}		
		
		NhanVien nv = new NhanVien();
		nv.setMaNV(maNV);nv.setTenNV(tenNV);nv.setGioiTinh(gioitinh);
		nv.setDiaChi(diachi);nv.setDienThoai(dienthoai);
		nhanvienDao.inserData(nv);
		
		TaiKhoan tk = new TaiKhoan();
		Role role = new Role();
		role.setIdRole(idRole);
		tk.setMaNV(maNV); tk.setPassword(pass);tk.setRole(role);
		
		taikhoanDao.inserData(tk);	
		
		return "redirect:/themnhanvien";
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
