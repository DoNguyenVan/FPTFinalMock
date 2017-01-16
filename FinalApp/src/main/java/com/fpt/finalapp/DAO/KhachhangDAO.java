/**
 * 
 */
package com.fpt.finalapp.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.finalapp.Utils.HibernateUtilKhachHang;
import com.fpt.finalapp.entities.KhachHang;

/**
 * @author HCD-Fresher055
 *
 */
@Transactional
@Repository
public class KhachhangDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private HibernateUtilKhachHang hibernateUtill;

	public KhachHang getKHByMaKH(String makh) {
		return (KhachHang) sessionFactory.getCurrentSession().get(KhachHang.class, makh);
	}

	public List<KhachHang> getListKhachhang() {
		return hibernateUtill.getListKH();
	}
	public void editKhach(KhachHang khachhang) {

		Session ss = sessionFactory.openSession();
		Transaction tx = null;

		try {

			tx = ss.beginTransaction();

			ss.saveOrUpdate(khachhang);

			tx.commit();
			System.out.println("sua thanh cong");
		} catch (Exception e) {
			System.out.println(e);
			tx.rollback();
		} finally {
			ss.close();
		}
	}

	public void deleteKhach(String maKH) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			KhachHang khach = getKhachhang(maKH);
			tx = session.beginTransaction();
			session.delete(khach);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}

	}
	
	public KhachHang getKhachhang(String id) {
		Session session = null;
		KhachHang user = null;
		try {
			session = sessionFactory.openSession();
			user = (KhachHang) session.load(KhachHang.class, id);
			Hibernate.initialize(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}
	public List<KhachHang> getKHByProp(String keySearch) {
		return hibernateUtill.searchByPropertyKH(KhachHang.class, keySearch);
	}
	public List<KhachHang> getAllKhachhang(int page) {

		return hibernateUtill.fetchAll(KhachHang.class, page);
	}
	

}
