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
@Table(name = "[dbo].[HUYHANGKH]")
public class HuyHang {

	@Id
	@Column(name = "MaHuyHang")
	private String maHuyHang;

	@Column(name = "SoLuong")
	private int soLuong;

	@Column(name = "Note")
	private String note;

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
	public HuyHang() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maHuyHang
	 * @param soLuong
	 * @param note
	 * @param thanhTien
	 * @param hoaDonBan
	 * @param vatTuCu
	 */
	public HuyHang(String maHuyHang, int soLuong, String note, float thanhTien, HoaDonBan hoaDonBan, VatTuCu vatTuCu) {
		super();
		this.maHuyHang = maHuyHang;
		this.soLuong = soLuong;
		this.note = note;
		this.thanhTien = thanhTien;
		this.hoaDonBan = hoaDonBan;
		this.vatTuCu = vatTuCu;
	}

	/**
	 * @return the maHuyHang
	 */
	public String getMaHuyHang() {
		return maHuyHang;
	}

	/**
	 * @param maHuyHang
	 *            the maHuyHang to set
	 */
	public void setMaHuyHang(String maHuyHang) {
		this.maHuyHang = maHuyHang;
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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
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
