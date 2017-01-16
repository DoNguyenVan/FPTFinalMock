/**
 * 
 */
package com.fpt.finalapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author HCD-Fresher055
 *
 */
@Entity
@Table(name="[dbo].[KHACHHANG]")
public class KhachHang {
	
	@Id
	@Column(name="MaKH")
	private String maKH;
	
	@Column(name="TenKH")
	private String tenKH;
	
	@Column(name="DiaChi")
	private String diaChi;
	
	@Column(name="Phone")
	private String phone;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="khachHang")
	private Set<HoaDonBan> setHoaDonBan = new HashSet<>();

	/**
	 * 
	 */
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maKH
	 * @param tenKH
	 * @param diaChi
	 * @param phone
	 * @param setHoaDonBan
	 */
	public KhachHang(String maKH, String tenKH, String diaChi, String phone, Set<HoaDonBan> setHoaDonBan) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.phone = phone;
		this.setHoaDonBan = setHoaDonBan;
	}

	/**
	 * @return the maKH
	 */
	public String getMaKH() {
		return maKH;
	}

	/**
	 * @param maKH the maKH to set
	 */
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	/**
	 * @return the tenKH
	 */
	public String getTenKH() {
		return tenKH;
	}

	/**
	 * @param tenKH the tenKH to set
	 */
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the setHoaDonBan
	 */
	public Set<HoaDonBan> getSetHoaDonBan() {
		return setHoaDonBan;
	}

	/**
	 * @param setHoaDonBan the setHoaDonBan to set
	 */
	public void setSetHoaDonBan(Set<HoaDonBan> setHoaDonBan) {
		this.setHoaDonBan = setHoaDonBan;
	}
	
	

}
