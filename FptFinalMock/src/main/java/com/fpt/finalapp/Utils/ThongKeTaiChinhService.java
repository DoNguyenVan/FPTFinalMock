/**
 * 
 */
package com.fpt.finalapp.Utils;

import java.util.Date;

/**
 * @author HCD-Fresher055
 *
 */
public interface ThongKeTaiChinhService {
	
	public double getTongTienBan(Date beginDate, Date endDate);
	
	public double getTongTienNhap(Date beginDate,Date endDate);
	
	public double getTongTienHuyHang(Date beginDate, Date endDate);
	
	public double getTongTienTraHang(Date beginDate, Date endDate);
	
}
