package com.fpt.finalapp.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.finalapp.Utils.HibernateUtilKhachHang;
import com.fpt.finalapp.entities.NhanVien;


@Repository
@Transactional
public class NhanVienDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateUtilKhachHang hibernateUtill;
	
	@SuppressWarnings("unchecked")
	public List<NhanVien> listNhanVien() {
		String sql = "Select new " + NhanVien.class.getName()//
				+ "(a.maNV, a.tenNV, a.gioiTinh, a.ngaySinh, a.diaChi, a.dienThoai, a.luong, a.tamUng) "//
				+ " from " + NhanVien.class.getName() + " a ";
		System.out.println(sql);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	public void inserData(NhanVien users) {

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(users);

	}

	public int getlastvalue() {

		Session session = sessionFactory.getCurrentSession();

		Long count = (Long) session.createQuery("select count(*) from " + NhanVien.class.getName()).uniqueResult();
		return count.intValue();
	}

	// lay username tu database de login
	public NhanVien getNhanVien(String id) {
		Session session = null;
		NhanVien user = null;
		try {
			session = sessionFactory.openSession();
			user = (NhanVien) session.load(NhanVien.class, id);
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

	public NhanVien getKHByMaKH(String makh) {
		return (NhanVien) sessionFactory.getCurrentSession().get(NhanVien.class, makh);
	}

	public List<NhanVien> getListNhanVien() {
		return hibernateUtill.getListNV();
	}
	public void editNhanvien(NhanVien khachhang) {

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

	public void deleteNhan(String maKH) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			NhanVien khach = getNhanvien(maKH);
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
	
	public NhanVien getNhanvien(String id) {
		Session session = null;
		NhanVien user = null;
		try {
			session = sessionFactory.openSession();
			user = (NhanVien) session.load(NhanVien.class, id);
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
	public List<NhanVien> getKHByProp(String keySearch) {
		return hibernateUtill.searchByPropertyKH(NhanVien.class, keySearch);
	}
	public List<NhanVien> getAllKhachhang(int page) {

		return hibernateUtill.fetchAll(NhanVien.class, page);
	}
	
}
