/**
 * 
 */
package com.fpt.finalapp.entities;

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
@Table(name = "[dbo].[LOAIVATTU]")
public class LoaiVatTu {

	@Id
	@Column(name = "MaLoaiVT")
	private String maLoaiVT;

	@Column(name = "TenLoaiVT")
	private String tenLoaiVT;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="loaiVatTu")
	private Set<VatTuMoi> setVatTuMoi = new HashSet<VatTuMoi>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="loaiVatTu")
	private Set<VatTuCu> setVatTuCu = new HashSet<VatTuCu>();

	/**
	 * 
	 */
	public LoaiVatTu() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maLoaiVT
	 * @param tenLoaiVT
	 * @param setVatTuMoi
	 * @param setVatTuCu
	 */
	public LoaiVatTu(String maLoaiVT, String tenLoaiVT, Set<VatTuMoi> setVatTuMoi, Set<VatTuCu> setVatTuCu) {
		super();
		this.maLoaiVT = maLoaiVT;
		this.tenLoaiVT = tenLoaiVT;
		this.setVatTuMoi = setVatTuMoi;
		this.setVatTuCu = setVatTuCu;
	}

	/**
	 * @return the maLoaiVT
	 */
	public String getMaLoaiVT() {
		return maLoaiVT;
	}

	/**
	 * @param maLoaiVT the maLoaiVT to set
	 */
	public void setMaLoaiVT(String maLoaiVT) {
		this.maLoaiVT = maLoaiVT;
	}

	/**
	 * @return the tenLoaiVT
	 */
	public String getTenLoaiVT() {
		return tenLoaiVT;
	}

	/**
	 * @param tenLoaiVT the tenLoaiVT to set
	 */
	public void setTenLoaiVT(String tenLoaiVT) {
		this.tenLoaiVT = tenLoaiVT;
	}

	/**
	 * @return the setVatTuMoi
	 */
	public Set<VatTuMoi> getSetVatTuMoi() {
		return setVatTuMoi;
	}

	/**
	 * @param setVatTuMoi the setVatTuMoi to set
	 */
	public void setSetVatTuMoi(Set<VatTuMoi> setVatTuMoi) {
		this.setVatTuMoi = setVatTuMoi;
	}

	/**
	 * @return the setVatTuCu
	 */
	public Set<VatTuCu> getSetVatTuCu() {
		return setVatTuCu;
	}

	/**
	 * @param setVatTuCu the setVatTuCu to set
	 */
	public void setSetVatTuCu(Set<VatTuCu> setVatTuCu) {
		this.setVatTuCu = setVatTuCu;
	}
	
	

}
