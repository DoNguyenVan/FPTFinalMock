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

@Entity
@Table(name = "[dbo].[VATTUMOI]")
public class VatTuMoi {

	@Id
	@Column(name = "MaVT")
	private String maVT;

	@Column(name = "TenVT")
	private String tenVT;

	@Column(name = "DonGia")
	private String donGia;

	@Column(name = "DonVi")
	private String donVi;

	@Column(name = "HanSuDung")
	private Date hanSuDung;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaloaiVT", referencedColumnName = "MaloaiVT")
	private LoaiVatTu loaiVatTu;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vatTuMoi")
	private Set<TraHang> setTraHang = new HashSet<TraHang>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vatTuMoi")
	private Set<ChiTietHoaDonNhap> setChiTietHoaDonNhap = new HashSet<ChiTietHoaDonNhap>();

	/**
	 * 
	 */
	public VatTuMoi() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maVT
	 * @param tenVT
	 * @param donGia
	 * @param donVi
	 * @param hanSuDung
	 * @param loaiVatTu
	 * @param setTraHang
	 * @param setChiTietHoaDonNhap
	 */
	public VatTuMoi(String maVT, String tenVT, String donGia, String donVi, Date hanSuDung, LoaiVatTu loaiVatTu,
			Set<TraHang> setTraHang, Set<ChiTietHoaDonNhap> setChiTietHoaDonNhap) {
		super();
		this.maVT = maVT;
		this.tenVT = tenVT;
		this.donGia = donGia;
		this.donVi = donVi;
		this.hanSuDung = hanSuDung;
		this.loaiVatTu = loaiVatTu;
		this.setTraHang = setTraHang;
		this.setChiTietHoaDonNhap = setChiTietHoaDonNhap;
	}

	/**
	 * @return the maVT
	 */
	public String getMaVT() {
		return maVT;
	}

	/**
	 * @param maVT
	 *            the maVT to set
	 */
	public void setMaVT(String maVT) {
		this.maVT = maVT;
	}

	/**
	 * @return the tenVT
	 */
	public String getTenVT() {
		return tenVT;
	}

	/**
	 * @param tenVT
	 *            the tenVT to set
	 */
	public void setTenVT(String tenVT) {
		this.tenVT = tenVT;
	}

	/**
	 * @return the donGia
	 */
	public String getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia
	 *            the donGia to set
	 */
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

	/**
	 * @return the donVi
	 */
	public String getDonVi() {
		return donVi;
	}

	/**
	 * @param donVi
	 *            the donVi to set
	 */
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	/**
	 * @return the hanSuDung
	 */
	public Date getHanSuDung() {
		return hanSuDung;
	}

	/**
	 * @param hanSuDung
	 *            the hanSuDung to set
	 */
	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	/**
	 * @return the loaiVatTu
	 */
	public LoaiVatTu getLoaiVatTu() {
		return loaiVatTu;
	}

	/**
	 * @param loaiVatTu
	 *            the loaiVatTu to set
	 */
	public void setLoaiVatTu(LoaiVatTu loaiVatTu) {
		this.loaiVatTu = loaiVatTu;
	}

	/**
	 * @return the setTraHang
	 */
	public Set<TraHang> getSetTraHang() {
		return setTraHang;
	}

	/**
	 * @param setTraHang
	 *            the setTraHang to set
	 */
	public void setSetTraHang(Set<TraHang> setTraHang) {
		this.setTraHang = setTraHang;
	}

	/**
	 * @return the setChiTietHoaDonNhap
	 */
	public Set<ChiTietHoaDonNhap> getSetChiTietHoaDonNhap() {
		return setChiTietHoaDonNhap;
	}

	/**
	 * @param setChiTietHoaDonNhap
	 *            the setChiTietHoaDonNhap to set
	 */
	public void setSetChiTietHoaDonNhap(Set<ChiTietHoaDonNhap> setChiTietHoaDonNhap) {
		this.setChiTietHoaDonNhap = setChiTietHoaDonNhap;
	}

}
