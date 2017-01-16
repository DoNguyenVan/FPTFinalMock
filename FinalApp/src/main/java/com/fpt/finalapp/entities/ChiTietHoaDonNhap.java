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

@Entity
@Table(name="[dbo].[CHITIETHOADONNH]")
public class ChiTietHoaDonNhap {
	
	@Id
	@Column(name="MaChiTietHDNH")
	private String maChiTietHoaDonNhapHang;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaHoaDon", referencedColumnName="MaHoaDon")
	private HoaDonNhap hoaDonNhap;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaVT", referencedColumnName="MaVT")
	private VatTuMoi vatTuMoi;
	
	@Column(name="SoLuong")
	private int soLuong;
	
	@Column(name="GhiChu")
	private String ghiChu;
	
	@Column(name="ThanhTien")
	private float thanhTien;
	
	

	/**
	 * 
	 */
	public ChiTietHoaDonNhap() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param maChiTietHoaDonNhapHang
	 * @param hoaDonNhap
	 * @param vatTuMoi
	 * @param soLuong
	 * @param ghiChu
	 * @param thanhTien
	 */
	public ChiTietHoaDonNhap(String maChiTietHoaDonNhapHang, HoaDonNhap hoaDonNhap, VatTuMoi vatTuMoi, int soLuong,
			String ghiChu, float thanhTien) {
		super();
		this.maChiTietHoaDonNhapHang = maChiTietHoaDonNhapHang;
		this.hoaDonNhap = hoaDonNhap;
		this.vatTuMoi = vatTuMoi;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
		this.thanhTien = thanhTien;
	}



	/**
	 * @return the maChiTietHoaDonNhapHang
	 */
	public String getMaChiTietHoaDonNhapHang() {
		return maChiTietHoaDonNhapHang;
	}



	/**
	 * @param maChiTietHoaDonNhapHang the maChiTietHoaDonNhapHang to set
	 */
	public void setMaChiTietHoaDonNhapHang(String maChiTietHoaDonNhapHang) {
		this.maChiTietHoaDonNhapHang = maChiTietHoaDonNhapHang;
	}



	/**
	 * @return the hoaDonNhap
	 */
	public HoaDonNhap getHoaDonNhap() {
		return hoaDonNhap;
	}



	/**
	 * @param hoaDonNhap the hoaDonNhap to set
	 */
	public void setHoaDonNhap(HoaDonNhap hoaDonNhap) {
		this.hoaDonNhap = hoaDonNhap;
	}



	/**
	 * @return the vatTuMoi
	 */
	public VatTuMoi getVatTuMoi() {
		return vatTuMoi;
	}



	/**
	 * @param vatTuMoi the vatTuMoi to set
	 */
	public void setVatTuMoi(VatTuMoi vatTuMoi) {
		this.vatTuMoi = vatTuMoi;
	}



	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}



	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	/**
	 * @return the ghiChu
	 */
	public String getGhiChu() {
		return ghiChu;
	}



	/**
	 * @param ghiChu the ghiChu to set
	 */
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}



	/**
	 * @return the thanhTien
	 */
	public float getThanhTien() {
		return thanhTien;
	}



	/**
	 * @param thanhTien the thanhTien to set
	 */
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	

}
