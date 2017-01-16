/**
 * 
 */
package com.fpt.finalapp.entities;

import java.util.Date;
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
@Table(name = "[dbo].[NHANVIEN]")
public class NhanVien {

	@Id
	@Column(name = "MaNV")
	private String maNV;

	@Column(name = "TenNV")
	private String tenNV;

	@Column(name = "GioiTinh")
	private String gioiTinh;

	@Column(name = "NgaySinh")
	private Date ngaySinh;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "DienThoai")
	private String dienThoai;

	@Column(name = "Luong")
	private float luong;

	@Column(name = "TamUng")
	private float tamUng;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVienNhap")
	Set<HoaDonNhap> setHoaDonNhap = new HashSet<HoaDonNhap>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVienBan")
	Set<HoaDonBan> setHoaDonBan = new HashSet<HoaDonBan>();
	

	/**
	 * 
	 */
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param maNV
	 * @param tenNV
	 * @param gioiTinh
	 * @param ngaySinh
	 * @param diaChi
	 * @param dienThoai
	 * @param luong
	 * @param tamUng
	 * @param setHoaDonNhap
	 * @param setHoaDonBan
	 * @param taiKhoan
	 */
	public NhanVien(String maNV, String tenNV, String gioiTinh, Date ngaySinh, String diaChi, String dienThoai,
			float luong, float tamUng, Set<HoaDonNhap> setHoaDonNhap, Set<HoaDonBan> setHoaDonBan) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.luong = luong;
		this.tamUng = tamUng;
		this.setHoaDonNhap = setHoaDonNhap;
		this.setHoaDonBan = setHoaDonBan;
		
	}

	public NhanVien(String maNV, String tenNV, String gioiTinh, Date ngaySinh, String diaChi, String dienThoai,
			float luong, float tamUng) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.luong = luong;
		this.tamUng = tamUng;

	}

	public NhanVien(String maNV, String tenNV, String gioiTinh, Date ngaySinh, String diaChi, String dienThoai) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
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
	 * @return the tenNV
	 */
	public String getTenNV() {
		return tenNV;
	}

	/**
	 * @param tenNV
	 *            the tenNV to set
	 */
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh
	 *            the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh
	 *            the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
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
	 * @return the luong
	 */
	public float getLuong() {
		return luong;
	}

	/**
	 * @param luong
	 *            the luong to set
	 */
	public void setLuong(float luong) {
		this.luong = luong;
	}

	/**
	 * @return the tamUng
	 */
	public float getTamUng() {
		return tamUng;
	}

	/**
	 * @param tamUng
	 *            the tamUng to set
	 */
	public void setTamUng(float tamUng) {
		this.tamUng = tamUng;
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

	/**
	 * @return the setHoaDonBan
	 */
	public Set<HoaDonBan> getSetHoaDonBan() {
		return setHoaDonBan;
	}

	/**
	 * @param setHoaDonBan
	 *            the setHoaDonBan to set
	 */
	public void setSetHoaDonBan(Set<HoaDonBan> setHoaDonBan) {
		this.setHoaDonBan = setHoaDonBan;
	}


	
	

}
