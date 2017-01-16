package com.fpt.finalapp.entities;

import java.sql.Date;

public class NhanVienAll {
	private String maNV;
	private String tenNV;
	private String gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String dienThoai;
	private float luong;
	private float tamUng;
	private String password;
	private String idRole;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	public float getTamUng() {
		return tamUng;
	}
	public void setTamUng(float tamUng) {
		this.tamUng = tamUng;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	public NhanVienAll(String maNV, String tenNV, String gioiTinh, Date ngaySinh, String diaChi, String dienThoai,
			float luong, float tamUng, String password, String idRole) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.luong = luong;
		this.tamUng = tamUng;
		this.password = password;
		this.idRole = idRole;
	}
	public NhanVienAll() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
