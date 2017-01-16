package com.fpt.finalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {

	@RequestMapping("/thongke")
	public String showStatistics() {
		return "thongke";
	}

}
