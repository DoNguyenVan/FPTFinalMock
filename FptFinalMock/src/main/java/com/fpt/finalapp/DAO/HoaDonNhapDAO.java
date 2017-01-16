/**
 * 
 */
package com.fpt.finalapp.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.finalapp.Utils.HibernateUtil;
import com.fpt.finalapp.entities.HoaDonNhap;

/**
 * @author HCD-Fresher055
 *
 */
@Repository
@Transactional
public class HoaDonNhapDAO {

	@Autowired
	private HibernateUtil hibernateUtil;

	public List<HoaDonNhap> getListHoaDonNhap(Date beginDate, Date endDate) {
		return hibernateUtil.getListBetween(HoaDonNhap.class, "ngayLap", beginDate, endDate);
	}
	
	
	
}
