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
import com.fpt.finalapp.entities.HoaDonBan;

/**
 * @author HCD-Fresher055
 *
 */
@Transactional
@Repository
public class HoaDonBanDAO {

	@Autowired
	private HibernateUtil hibernateUtil;
	
	public List<HoaDonBan> listHoaDonBan(Date beginDate, Date endDate) {
		return hibernateUtil.getListBetween(HoaDonBan.class, "ngayLap", beginDate, endDate);
	}

}
