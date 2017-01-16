package com.fpt.finalapp.Utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fpt.finalapp.DAO.TaiKhoanDAO;
import com.fpt.finalapp.entities.TaiKhoan;

@Service
public class MyDBAuthenticationService implements UserDetailsService {

	@Autowired
	private TaiKhoanDAO taiKhoanDAO;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taiKhoan = taiKhoanDAO.layTaiKhoan(username);
		if (taiKhoan == null) {
			throw new UsernameNotFoundException("User " + username + "not found exception ");
		}

		List<String> listRole = new ArrayList<String>();
		listRole.add(taiKhoan.getRole().getIdRole().trim());
		List<GrantedAuthority> listAu = new ArrayList<GrantedAuthority>();
		for (String role : listRole) {
			GrantedAuthority gAuthority = new SimpleGrantedAuthority("ROLE_" + role);
			listAu.add(gAuthority);
		}

		UserDetails userDetails = new org.springframework.security.core.userdetails.User(taiKhoan.getMaNV(),
				taiKhoan.getPassword(), listAu);
		return userDetails;
	}
}