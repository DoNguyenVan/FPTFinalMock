/**
 * 
 */
package com.fpt.finalapp.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.finalapp.DAO.HoaDonBanDAO;
import com.fpt.finalapp.DAO.HoaDonNhapDAO;
import com.fpt.finalapp.Utils.ThongKeTaiChinhService;
import com.fpt.finalapp.entities.HoaDonBan;
import com.fpt.finalapp.entities.HoaDonNhap;
import com.fpt.finalapp.entities.HuyHang;
import com.fpt.finalapp.entities.TraHang;

/**
 * @author HCD-Fresher055
 *
 */

@Service
public class ThongKeTaiChinhServicesImpl implements ThongKeTaiChinhService {

	@Autowired
	private HoaDonBanDAO hoaDonBanDAO;

	@Autowired
	private HoaDonNhapDAO hoaDonNhapDAO;

	@Override
	public double getTongTienBan(Date beginDate, Date endDate) {
		List<HoaDonBan> list = hoaDonBanDAO.listHoaDonBan(beginDate, endDate);
		double result = 0.0;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				result += list.get(i).getTongTien();
			}
		}
		return result;
	}

	@Override
	public double getTongTienNhap(Date beginDate, Date endDate) {
		double result = 0.0;
		List<HoaDonNhap> list = hoaDonNhapDAO.getListHoaDonNhap(beginDate, endDate);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				result += list.get(i).getTongTien();
			}
		}
		return result;
	}

	@Override
	public double getTongTienHuyHang(Date beginDate, Date endDate) {
		double result = 0.0;
		List<HoaDonBan> list = hoaDonBanDAO.listHoaDonBan(beginDate, endDate);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Set<HuyHang> set = new HashSet<>();
				set = list.get(i).getSetHuyHang();
				if (set.size() > 0) {
					for (Iterator<HuyHang> it = set.iterator(); it.hasNext();) {
						HuyHang huyhang = it.next();
						result += huyhang.getThanhTien();
					}
				}
			}
		}
		return result;
	}
	@Override
	public double getTongTienTraHang(Date beginDate, Date endDate) {
		double result = 0.0;
		List<HoaDonNhap> list = hoaDonNhapDAO.getListHoaDonNhap(beginDate, endDate);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Set<TraHang> set = new HashSet<>();
				set = list.get(i).getSetTraHang();
				if (set.size() > 0) {
					for (Iterator<TraHang> it = set.iterator(); it.hasNext();) {
						TraHang traHang = it.next();
						result += traHang.getThanhTien();
					}
				}
			}
		}
		return result;
	}
	

}
