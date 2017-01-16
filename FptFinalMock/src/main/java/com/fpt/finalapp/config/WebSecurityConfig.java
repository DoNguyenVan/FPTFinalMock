package com.fpt.finalapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.fpt.finalapp.Utils.MyDBAuthenticationService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyDBAuthenticationService myDBAuthenticationService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myDBAuthenticationService);

	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/", "/login").permitAll();
		
		http.authorizeRequests().antMatchers("/thongke", "/thongKeTaiChinh").access("hasAnyRole('r1', 'r2', 'r3')");
		
		http.authorizeRequests().and().formLogin().loginProcessingUrl("/login").loginPage("/login")
				.defaultSuccessUrl("/loginsuccess").failureUrl("/login?error=true").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
		
		http.headers().frameOptions().disable();
	}

}
