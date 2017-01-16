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
@Table(name = "[dbo].[VATTUCU]")
public class VatTuCu {

	@Id
	@Column(name = "MaVT")
	private String maVT;

	@Column(name = "TenVT")
	private String tenVT;

	@Column(name = "DonGia")
	private float donGia;

	@Column(name = "DonVi")
	private String donVi;

	@Column(name = "HanSuDung")
	private Date hanSuDung;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaLoaiVT", referencedColumnName = "MaLoaiVT")
	private LoaiVatTu loaiVatTu;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vatTuCu")
	private Set<ChiTietHoaDonBan> setChiTietHoaDonBan = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vatTuCu")
	private Set<HuyHang> setHuyHang = new HashSet<>();

	/**
	 * 
	 */
	public VatTuCu() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maVT
	 * @param tenVT
	 * @param donGia
	 * @param donVi
	 * @param hanSuDung
	 * @param loaiVatTu
	 * @param setChiTietHoaDonBan
	 * @param setHuyHang
	 */
	public VatTuCu(String maVT, String tenVT, float donGia, String donVi, Date hanSuDung, LoaiVatTu loaiVatTu,
			Set<ChiTietHoaDonBan> setChiTietHoaDonBan, Set<HuyHang> setHuyHang) {
		super();
		this.maVT = maVT;
		this.tenVT = tenVT;
		this.donGia = donGia;
		this.donVi = donVi;
		this.hanSuDung = hanSuDung;
		this.loaiVatTu = loaiVatTu;
		this.setChiTietHoaDonBan = setChiTietHoaDonBan;
		this.setHuyHang = setHuyHang;
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
	public float getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia
	 *            the donGia to set
	 */
	public void setDonGia(float donGia) {
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
