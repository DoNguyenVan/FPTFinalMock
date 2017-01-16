/**
 * 
 */
package com.fpt.finalapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.finalapp.Utils.ThongKeTaiChinhService;

/**
 * @author HCD-Fresher055
 *
 */

@Controller
public class APIThongKeController {

	@Autowired
	ThongKeTaiChinhService thongKeTaiChinhService;

	@RequestMapping("/api/thongKeTaiChinh")
	@ResponseBody
	public Map<String, Double> thongKeTaiChinh(@RequestParam(name = "thang") String thang,
			@RequestParam(name = "nam") String nam) throws ParseException {
		Map<String, Double> result = new HashMap<>();
		YearMonth yearMonth = YearMonth.of(Integer.valueOf(nam), Integer.valueOf(thang));
		System.out.println(yearMonth.lengthOfMonth());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String begin = nam+"-"+thang+"-01 00:00:00";
		String end = nam+"-"+thang+"-"+yearMonth.lengthOfMonth()+" 23:59:59";
		Date beginDate = format.parse(begin);
		Date endDate = format.parse(end);
		double tongTienBan = thongKeTaiChinhService.getTongTienBan(beginDate, endDate);
		double tongTienNhap = thongKeTaiChinhService.getTongTienNhap(beginDate, endDate);
		double tongTienHuyHang = thongKeTaiChinhService.getTongTienHuyHang(beginDate, endDate);
		double tongTienTraHang = thongKeTaiChinhService.getTongTienTraHang(beginDate, endDate);
		double tongThu = tongTienBan+tongTienTraHang;
		double tongChi = tongTienNhap+tongTienHuyHang;
		result.put("tongTienBan", tongTienBan);
		result.put("tongTienNhap", tongTienNhap);
		result.put("tongTienHuyHang", tongTienHuyHang);
		result.put("tongTienTraHang", tongTienTraHang);
		result.put("tongThu", tongThu);
		result.put("tongChi", tongChi);
		result.put("doanhThu", tongThu-tongChi);
		return result;
	}
	
	

}
