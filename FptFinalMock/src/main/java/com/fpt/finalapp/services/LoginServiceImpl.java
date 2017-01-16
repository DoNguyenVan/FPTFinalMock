/**
 * 
 */
package com.fpt.finalapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.finalapp.DAO.TaiKhoanDAO;
import com.fpt.finalapp.Utils.LoginUtil;
import com.fpt.finalapp.entities.TaiKhoan;

/**
 * @author HCD-Fresher055
 *
 */
@Service
public class LoginServiceImpl implements LoginUtil {
	
	@Autowired
	private TaiKhoanDAO taiKhoanDAO;

	/* (non-Javadoc)
	 * @see com.fpt.finalapp.Utils.LoginUtil#layTaiKhoanBoiId(java.lang.String)
	 */
	@Override
	public TaiKhoan layTaiKhoanBoiId(String username) {
		return taiKhoanDAO.layTaiKhoan(username);
	}

}
