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
@Table(name="[dbo].[HOADONNH]")
public class HoaDonNhap {
	
	@Id
	@Column(name="MAHOADON")
	private String maHoaDon;
	
	@Column(name="NgayLap")
	private Date ngayLap;
	
	@Column(name="TongTien")
	private float tongTien;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaNV", referencedColumnName="MaNV")
	private NhanVien nhanVienNhap;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NhaCC", referencedColumnName="IdNhaCC")
	private NhaCungCap nhaCungCap;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="hoaDonNhap")
	private Set<ChiTietHoaDonNhap> setChiTietHoaDonNhap = new HashSet<ChiTietHoaDonNhap>();
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="hoaDonNhap")
	private Set<TraHang> setTraHang = new HashSet<TraHang>();

	/**
	 * 
	 */
	public HoaDonNhap() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maHoaDon
	 * @param ngayLap
	 * @param tongTien
	 * @param nhanVienNhap
	 * @param nhaCungCap
	 * @param setChiTietHoaDonNhap
	 * @param setTraHang
	 */
	public HoaDonNhap(String maHoaDon, Date ngayLap, float tongTien, NhanVien nhanVienNhap, NhaCungCap nhaCungCap,
			Set<ChiTietHoaDonNhap> setChiTietHoaDonNhap, Set<TraHang> setTraHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.nhanVienNhap = nhanVienNhap;
		this.nhaCungCap = nhaCungCap;
		this.setChiTietHoaDonNhap = setChiTietHoaDonNhap;
		this.setTraHang = setTraHang;
	}

	/**
	 * @return the maHoaDon
	 */
	public String getMaHoaDon() {
		return maHoaDon;
	}

	/**
	 * @param maHoaDon the maHoaDon to set
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
	 * @param ngayLap the ngayLap to set
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
	 * @param tongTien the tongTien to set
	 */
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	/**
	 * @return the nhanVienNhap
	 */
	public NhanVien getNhanVienNhap() {
		return nhanVienNhap;
	}

	/**
	 * @param nhanVienNhap the nhanVienNhap to set
	 */
	public void setNhanVienNhap(NhanVien nhanVienNhap) {
		this.nhanVienNhap = nhanVienNhap;
	}

	/**
	 * @return the nhaCungCap
	 */
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	/**
	 * @param nhaCungCap the nhaCungCap to set
	 */
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	/**
	 * @return the setChiTietHoaDonNhap
	 */
	public Set<ChiTietHoaDonNhap> getSetChiTietHoaDonNhap() {
		return setChiTietHoaDonNhap;
	}

	/**
	 * @param setChiTietHoaDonNhap the setChiTietHoaDonNhap to set
	 */
	public void setSetChiTietHoaDonNhap(Set<ChiTietHoaDonNhap> setChiTietHoaDonNhap) {
		this.setChiTietHoaDonNhap = setChiTietHoaDonNhap;
	}

	/**
	 * @return the setTraHang
	 */
	public Set<TraHang> getSetTraHang() {
		return setTraHang;
	}

	/**
	 * @param setTraHang the setTraHang to set
	 */
	public void setSetTraHang(Set<TraHang> setTraHang) {
		this.setTraHang = setTraHang;
	}
	
	

}
