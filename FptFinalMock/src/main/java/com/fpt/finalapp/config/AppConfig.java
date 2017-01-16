package com.fpt.finalapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fpt.finalapp.entities.ChiTietHoaDonBan;
import com.fpt.finalapp.entities.ChiTietHoaDonNhap;
import com.fpt.finalapp.entities.HoaDonBan;
import com.fpt.finalapp.entities.HoaDonNhap;
import com.fpt.finalapp.entities.HuyHang;
import com.fpt.finalapp.entities.KhachHang;
import com.fpt.finalapp.entities.LoaiVatTu;
import com.fpt.finalapp.entities.NhaCungCap;
import com.fpt.finalapp.entities.NhanVien;
import com.fpt.finalapp.entities.Role;
import com.fpt.finalapp.entities.TaiKhoan;
import com.fpt.finalapp.entities.TraHang;
import com.fpt.finalapp.entities.VatTuCu;
import com.fpt.finalapp.entities.VatTuMoi;

@Configuration
@ComponentScan("com.fpt.finalapp.*")
@PropertySource("classpath:datasource-cfg.properties")
@EnableTransactionManagement
public class AppConfig {

	@Autowired
	Environment env;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("current_session_context_class", env.getProperty("current_session_context_class"));

		// properties.put("hibernate.show_sql", "true");
		// properties.put("hibernate.dialect",
		// "org.hibernate.dialect.MySQLDialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(TaiKhoan.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		sessionBuilder.addAnnotatedClass(NhanVien.class);
		sessionBuilder.addAnnotatedClass(VatTuCu.class);
		sessionBuilder.addAnnotatedClass(VatTuMoi.class);
		sessionBuilder.addAnnotatedClass(HoaDonBan.class);
		sessionBuilder.addAnnotatedClass(HoaDonNhap.class);
		sessionBuilder.addAnnotatedClass(ChiTietHoaDonBan.class);
		sessionBuilder.addAnnotatedClass(ChiTietHoaDonNhap.class);
		sessionBuilder.addAnnotatedClass(LoaiVatTu.class);
		sessionBuilder.addAnnotatedClass(KhachHang.class);
		sessionBuilder.addAnnotatedClass(NhaCungCap.class);
		sessionBuilder.addAnnotatedClass(HuyHang.class);
		sessionBuilder.addAnnotatedClass(TraHang.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	 @Bean(name = "messageSource")
	   public MessageSource getMessageResource()  {
	       ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
	  
	        
	       // file i18n/messages_xxx.properties
	       //i18n/message_en.properties
	       messageResource.setBasename("classpath:i18n/messages");
	     //  messageResource.setDefaultEncoding("UTF-8");
	       return messageResource;
	   }
	    
	   @Bean(name = "localeResolver")
	   public LocaleResolver getLocaleResolver()  {
	       CookieLocaleResolver resolver= new CookieLocaleResolver();
	       resolver.setCookieDomain("myAppLocaleCookie");
	     
	       // 60 p
	       resolver.setCookieMaxAge(60*60);
	       return resolver;
	   }
}
