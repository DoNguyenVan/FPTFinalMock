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
@Table(name = "[dbo].[CHITIETHOADONBH]")
public class ChiTietHoaDonBan {

	@Id
	@Column(name = "MaChiTetHDBH")
	private String maChiTetHDBH;

	@Column(name = "SoLuong")
	private int soLuong;

	@Column(name = "GhiChu")
	private String ghiChu;

	@Column(name = "ThanhTien")
	private float thanhTien;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaHoaDon", referencedColumnName = "MaHoaDon")
	private HoaDonBan hoaDonBan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaVT", referencedColumnName = "MaVT")
	private VatTuCu vatTuCu;

	/**
	 * 
	 */
	public ChiTietHoaDonBan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maChiTetHDBH
	 * @param soLuong
	 * @param ghiChu
	 * @param thanhTien
	 * @param hoaDonBan
	 * @param vatTuCu
	 */
	public ChiTietHoaDonBan(String maChiTetHDBH, int soLuong, String ghiChu, float thanhTien, HoaDonBan hoaDonBan,
			VatTuCu vatTuCu) {
		super();
		this.maChiTetHDBH = maChiTetHDBH;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
		this.thanhTien = thanhTien;
		this.hoaDonBan = hoaDonBan;
		this.vatTuCu = vatTuCu;
	}

	/**
	 * @return the maChiTetHDBH
	 */
	public String getMaChiTetHDBH() {
		return maChiTetHDBH;
	}

	/**
	 * @param maChiTetHDBH
	 *            the maChiTetHDBH to set
	 */
	public void setMaChiTetHDBH(String maChiTetHDBH) {
		this.maChiTetHDBH = maChiTetHDBH;
	}

	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}

	/**
	 * @param soLuong
	 *            the soLuong to set
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
	 * @param ghiChu
	 *            the ghiChu to set
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
	 * @param thanhTien
	 *            the thanhTien to set
	 */
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	/**
	 * @return the hoaDonBan
	 */
	public HoaDonBan getHoaDonBan() {
		return hoaDonBan;
	}

	/**
	 * @param hoaDonBan
	 *            the hoaDonBan to set
	 */
	public void setHoaDonBan(HoaDonBan hoaDonBan) {
		this.hoaDonBan = hoaDonBan;
	}

	/**
	 * @return the vatTuCu
	 */
	public VatTuCu getVatTuCu() {
		return vatTuCu;
	}

	/**
	 * @param vatTuCu
	 *            the vatTuCu to set
	 */
	public void setVatTuCu(VatTuCu vatTuCu) {
		this.vatTuCu = vatTuCu;
	}

}
