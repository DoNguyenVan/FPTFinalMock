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

@Entity
@Table(name = "[dbo].[NHACUNGCAP]")
public class NhaCungCap {

	@Id
	@Column(name = "IdNhaCC")
	private String idNhaCC;

	@Column(name = "TenNhaCC")
	private String tenNhaCC;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "DienThoai")
	private String dienThoai;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhaCungCap")
	private Set<HoaDonNhap> setHoaDonNhap = new HashSet<>();

	/**
	 * 
	 */
	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idNhaCC
	 * @param tenNhaCC
	 * @param diaChi
	 * @param dienThoai
	 * @param setHoaDonNhap
	 */
	public NhaCungCap(String idNhaCC, String tenNhaCC, String diaChi, String dienThoai, Set<HoaDonNhap> setHoaDonNhap) {
		super();
		this.idNhaCC = idNhaCC;
		this.tenNhaCC = tenNhaCC;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.setHoaDonNhap = setHoaDonNhap;
	}

	/**
	 * @return the idNhaCC
	 */
	public String getIdNhaCC() {
		return idNhaCC;
	}

	/**
	 * @param idNhaCC
	 *            the idNhaCC to set
	 */
	public void setIdNhaCC(String idNhaCC) {
		this.idNhaCC = idNhaCC;
	}

	/**
	 * @return the tenNhaCC
	 */
	public String getTenNhaCC() {
		return tenNhaCC;
	}

	/**
	 * @param tenNhaCC
	 *            the tenNhaCC to set
	 */
	public void setTenNhaCC(String tenNhaCC) {
		this.tenNhaCC = tenNhaCC;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi
	 *            the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/**
	 * @return the dienThoai
	 */
	public String getDienThoai() {
		return dienThoai;
	}

	/**
	 * @param dienThoai
	 *            the dienThoai to set
	 */
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	/**
	 * @return the setHoaDonNhap
	 */
	public Set<HoaDonNhap> getSetHoaDonNhap() {
		return setHoaDonNhap;
	}

	/**
	 * @param setHoaDonNhap
	 *            the setHoaDonNhap to set
	 */
	public void setSetHoaDonNhap(Set<HoaDonNhap> setHoaDonNhap) {
		this.setHoaDonNhap = setHoaDonNhap;
	}

}
