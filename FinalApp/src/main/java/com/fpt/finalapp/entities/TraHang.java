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
@Table(name="[dbo].[TRAHANGNHACC]")
public class TraHang {
	
	@Id
	@Column(name="MaTraHangNCC")
	private String maTraHangNCC;
	
	@Column(name="SoLuong")
	private int soLuong;
	
	@Column(name="Note")
	private String note;
	
	@Column(name="ThanhTien")
	private float thanhTien;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaHoaDon", referencedColumnName="MaHoaDon")
	private HoaDonNhap hoaDonNhap;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaVT", referencedColumnName="MaVT")
	private VatTuMoi vatTuMoi;
	
	
	
	/**
	 * 
	 */
	public TraHang() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param maTraHangNCC
	 * @param soLuong
	 * @param note
	 * @param thanhTien
	 * @param hoaDonNhap
	 * @param vatTuMoi
	 */
	public TraHang(String maTraHangNCC, int soLuong, String note, float thanhTien, HoaDonNhap hoaDonNhap,
			VatTuMoi vatTuMoi) {
		super();
		this.maTraHangNCC = maTraHangNCC;
		this.soLuong = soLuong;
		this.note = note;
		this.thanhTien = thanhTien;
		this.hoaDonNhap = hoaDonNhap;
		this.vatTuMoi = vatTuMoi;
	}



	/**
	 * @return the maTraHangNCC
	 */
	public String getMaTraHangNCC() {
		return maTraHangNCC;
	}



	/**
	 * @param maTraHangNCC the maTraHangNCC to set
	 */
	public void setMaTraHangNCC(String maTraHangNCC) {
		this.maTraHangNCC = maTraHangNCC;
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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}



	/**
	 * @param note the note to set
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
	 * @param thanhTien the thanhTien to set
	 */
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
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
	
	

}
