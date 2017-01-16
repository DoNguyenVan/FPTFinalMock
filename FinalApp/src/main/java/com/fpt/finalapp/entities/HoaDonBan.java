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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author HCD-Fresher055
 *
 */
@Entity
@Table(name = "[dbo].[HOADONBANA]")
public class HoaDonBan {

	@Id
	@Column(name = "MaHoaDon")
	private String maHoaDon;

	@Column(name = "NgayLap")
	private Date ngayLap;

	@Column(name = "TongTien")
	private float tongTien;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
	private NhanVien nhanVienBan;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "hoaDonBan")
	private Set<ChiTietHoaDonBan> setChiTietHoaDonBan = new HashSet<ChiTietHoaDonBan>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "hoaDonBan")
	private Set<HuyHang> setHuyHang = new HashSet<HuyHang>();

	/**
	 * 
	 */
	public HoaDonBan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maHoaDon
	 * @param ngayLap
	 * @param tongTien
	 * @param khachHang
	 * @param nhaVienBan
	 * @param setChiTietHoaDonBan
	 * @param setHuyHang
	 */
	public HoaDonBan(String maHoaDon, Date ngayLap, float tongTien, KhachHang khachHang, NhanVien nhanVienBan,
			Set<ChiTietHoaDonBan> setChiTietHoaDonBan, Set<HuyHang> setHuyHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.khachHang = khachHang;
		this.nhanVienBan = nhanVienBan;
		this.setChiTietHoaDonBan = setChiTietHoaDonBan;
		this.setHuyHang = setHuyHang;
	}

	/**
	 * @return the maHoaDon
	 */
	public String getMaHoaDon() {
		return maHoaDon;
	}

	/**
	 * @param maHoaDon
	 *            the maHoaDon to set
	 */
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	/**
	 * @return the ngayLap
	 */
	public Date getNgayLap() {
		return ngayLap;
	}

	/**
	 * @param ngayLap
	 *            the ngayLap to set
	 */
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	/**
	 * @return the tongTien
	 */
	public float getTongTien() {
		return tongTien;
	}

	/**
	 * @param tongTien
	 *            the tongTien to set
	 */
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	/**
	 * @return the khachHang
	 */
	public KhachHang getKhachHang() {
		return khachHang;
	}

	/**
	 * @param khachHang
	 *            the khachHang to set
	 */
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	/**
	 * @return the nhaVienBan
	 */
	public NhanVien getNhaVienBan() {
		return nhanVienBan;
	}

	/**
	 * @param nhaVienBan
	 *            the nhaVienBan to set
	 */
	public void setNhaVienBan(NhanVien nhaVienBan) {
		this.nhanVienBan = nhaVienBan;
	}

	/**
	 * @return the setChiTietHoaDonBan
	 */
	public Set<ChiTietHoaDonBan> getSetChiTietHoaDonBan() {
		return setChiTietHoaDonBan;
	}

	/**
	 * @param setChiTietHoaDonBan
	 *            the setChiTietHoaDonBan to set
	 */
	public void setSetChiTietHoaDonBan(Set<ChiTietHoaDonBan> setChiTietHoaDonBan) {
		this.setChiTietHoaDonBan = setChiTietHoaDonBan;
	}

	/**
	 * @return the setHuyHang
	 */
	public Set<HuyHang> getSetHuyHang() {
		return setHuyHang;
	}

	/**
	 * @param setHuyHang
	 *            the setHuyHang to set
	 */
	public void setSetHuyHang(Set<HuyHang> setHuyHang) {
		this.setHuyHang = setHuyHang;
	}

}
