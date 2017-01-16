/**
 * 
 */
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

import com.fpt.finalapp.Utils.HibernateUtil;
import com.fpt.finalapp.entities.TaiKhoan;

/**
 * @author HCD-Fresher055
 *
 */
@Transactional
@Repository
public class TaiKhoanDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	@Autowired
	private HibernateUtil hibernateUtill;

	public TaiKhoan layTaiKhoan(String username) {
		return hibernateUtill.findById(username, TaiKhoan.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<TaiKhoan> listTaiKhoan() {
		String sql = "Select new " + TaiKhoan.class.getName()//
				+ "(a.maNV, a.password, a.idRole) "//
				+ " from " + TaiKhoan.class.getName() + " a ";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	public void inserData(TaiKhoan users) {

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(users);

	}

	public int getlastvalue() {

		Session session = sessionFactory.getCurrentSession();

		Long count = (Long) session.createQuery("select count(*) from " + TaiKhoan.class.getName()).uniqueResult();
		return count.intValue();
	}

	// lay manv tu database de login
	public TaiKhoan getTaiKhoan(String id) {
		Session session = null;
		TaiKhoan user = null;
		try {
			session = sessionFactory.openSession();
			user = (TaiKhoan) session.load(TaiKhoan.class, id);
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

	public void update(TaiKhoan tk) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(tk);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void changePass(String id, String pass){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE " + TaiKhoan.class.getName() + " t SET t.password=:pass WHERE t.maNV=:maNV";
			Query query = session.createQuery(hql);
			query.setParameter("pass", pass);
			query.setParameter("maNV", id);
			query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	

}
