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
@Table(name="[dbo].[ROLE]")
public class Role {
	
	@Id
	@Column(name="IdRole")
	private String idRole;
	
	@Column(name="NameRole")
	private String nameRole;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="role")
	Set<TaiKhoan> setTaiKhoan = new HashSet<TaiKhoan>();

	/**
	 * 
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idRole
	 * @param nameRole
	 * @param setTaiKhoan
	 */
	public Role(String idRole, String nameRole, Set<TaiKhoan> setTaiKhoan) {
		super();
		this.idRole = idRole;
		this.nameRole = nameRole;
		this.setTaiKhoan = setTaiKhoan;
	}

	/**
	 * @return the idRole
	 */
	public String getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the nameRole
	 */
	public String getNameRole() {
		return nameRole;
	}

	/**
	 * @param nameRole the nameRole to set
	 */
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	/**
	 * @return the setTaiKhoan
	 */
	public Set<TaiKhoan> getSetTaiKhoan() {
		return setTaiKhoan;
	}

	/**
	 * @param setTaiKhoan the setTaiKhoan to set
	 */
	public void setSetTaiKhoan(Set<TaiKhoan> setTaiKhoan) {
		this.setTaiKhoan = setTaiKhoan;
	}
	
	

}
