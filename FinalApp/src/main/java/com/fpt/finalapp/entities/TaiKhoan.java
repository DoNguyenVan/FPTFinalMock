/**
 * 
 */
package com.fpt.finalapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author HCD-Fresher055
 *
 */
@Entity
@Table(name = "[dbo].[TAIKHOAN]")
public class TaiKhoan {

	@Id
	@Column(name = "MaNV")
	private String maNV;

	@Column(name = "Password")
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdRole", referencedColumnName = "IdRole")
	private Role role;

	
	/**
	 * 
	 */
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maNV
	 * @param password
	 * @param role
	 * @param nhanVien
	 */
	public TaiKhoan(String maNV, String password, Role role) {
		super();
		this.maNV = maNV;
		this.password = password;
		this.role = role;
		
	}

	/**
	 * @return the maNV
	 */
	public String getMaNV() {
		return maNV;
	}

	/**
	 * @param maNV
	 *            the maNV to set
	 */
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	

}
