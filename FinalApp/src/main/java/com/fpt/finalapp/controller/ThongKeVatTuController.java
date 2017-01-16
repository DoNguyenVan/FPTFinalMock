package com.fpt.finalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.finalapp.Utils.HibernateUtil;
import com.fpt.finalapp.entities.VatTuCu;
import com.fpt.finalapp.entities.VatTuMoi;

@Controller
public class ThongKeVatTuController {
	
	@Autowired
	HibernateUtil hibernate;
	
	@RequestMapping(value="/tkvattu")
	public String xemVatTu(Model model){
		List<VatTuCu> list1 = hibernate.fetchAllEntities(VatTuCu.class);
		List<VatTuMoi> list2 = hibernate.fetchAllEntities(VatTuMoi.class);
		
		model.addAttribute("list",list1);
		
		return "thongke";
	}

}
