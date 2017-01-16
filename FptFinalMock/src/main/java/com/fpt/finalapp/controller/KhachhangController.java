package com.fpt.finalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.finalapp.DAO.KhachhangDAO;
import com.fpt.finalapp.entities.KhachHang;

@Controller
public class KhachhangController {

	@Autowired
	private KhachhangDAO khachhangDao;

	@RequestMapping(value = "/thongtinkhachhang")
	public String listKhachhang(Model model, @RequestParam(name = "id", required = false) String id) {

		List<KhachHang> list = khachhangDao.getListKhachhang();
		KhachHang kh = new KhachHang();
		/*if (id != null) {
			em = emDao.getUserById(id);

			model.addAttribute("msg", "true");
		}*/

		//model.addAttribute("employee", em);

		model.addAttribute("list", list);
		return "thongtinkhachhang";
	}

	/*@RequestMapping(value = "/commitEm", method = RequestMethod.POST)
	public String getFormUpdate(HttpServletRequest request, Model model, @ModelAttribute("employee") Employee em) {
		String colunm = request.getParameter("column");
		System.out.println("gia tri sua" + colunm);
		emDao.commit(em);
		// model.addAttribute("msg", "Update or Add Succesfully");

		return "redirect:/employees";

	}*/

	//
	
	/*@RequestMapping(value = "/deleteEm", method = RequestMethod.GET)
	public String getFormUpdate(Model model, @RequestParam("id") String id) {
		Employee em = emDao.getUserById(id);
		emDao.deleteEm(em);
		return "redirect:/employees";

	}*/
	
	/*@RequestMapping(value = "/deleteEm", method = RequestMethod.GET)
	public String getFormUpdate(Model model, @RequestParam("id") String id) {
		Employee em = emDao.getUserById(id);
		emDao.deleteEm(em);
		return "redirect:/employees";
	
	}*/

	/*@RequestMapping(value = "/table_edit_ajax.php", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeAPI(@RequestParam(name = "id") String id,
			@RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName,
			@RequestParam(name = "email") String email, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "dayOf") String dayOf) {
		Employee employee = new Employee(id, firstName, lastName, email, phone, dayOf);
		emDao.commit(employee);
		return employee;

	}*/
	@RequestMapping("/search")
	public @ResponseBody List<KhachHang> findEmployeeByProperties(
			@RequestParam(name = "keySearch") String keySearch) {
		List<KhachHang> list = khachhangDao.getKHByProp(keySearch);
		System.out.println("tim kiem dc");
		return list;
	}

}
