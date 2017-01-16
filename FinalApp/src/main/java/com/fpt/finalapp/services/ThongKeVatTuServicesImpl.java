package com.fpt.finalapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.finalapp.DAO.HoaDonBanDAO;
import com.fpt.finalapp.DAO.HoaDonNhapDAO;
import com.fpt.finalapp.Utils.ThongKeVatTuService;
import com.fpt.finalapp.entities.ChiTietHoaDonNhap;
import com.fpt.finalapp.entities.HoaDonBan;
import com.fpt.finalapp.entities.HoaDonNhap;
import com.fpt.finalapp.entities.VatTuMoi;

@Service
public class ThongKeVatTuServicesImpl implements ThongKeVatTuService{
	
	@Autowired
	private HoaDonNhapDAO hoaDonNhapDAO;

	@Override
	public List<VatTuMoi> getAllVatTuMoi(Date beginDate, Date endDate) {
		List<VatTuMoi> result = new ArrayList<>();
		List<HoaDonNhap> listHoaDonNhap = hoaDonNhapDAO.getListHoaDonNhap(beginDate, endDate);
		if(listHoaDonNhap!=null && listHoaDonNhap.size()>0) {
			for(int i=0; i<listHoaDonNhap.size();i++) {
				Set<ChiTietHoaDonNhap> set = new HashSet<>();
				set = listHoaDonNhap.get(i).getSetChiTietHoaDonNhap();
				if(set!=null && set.size()>0) {
					for(Iterator<ChiTietHoaDonNhap> it = set.iterator(); it.hasNext();) {
						ChiTietHoaDonNhap chiTiet = it.next();
						result.add(chiTiet.getVatTuMoi());
					}
				}
			}
		}
		return null;
	}

}
