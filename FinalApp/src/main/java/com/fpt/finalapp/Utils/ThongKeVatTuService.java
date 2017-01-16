/**
 * 
 */
package com.fpt.finalapp.Utils;

import java.util.Date;
import java.util.List;

import com.fpt.finalapp.entities.VatTuMoi;

/**
 * @author HCD-Fresher055
 *
 */
public interface ThongKeVatTuService {
	
	public List<VatTuMoi> getAllVatTuMoi(Date beginDate, Date endDate);

}
