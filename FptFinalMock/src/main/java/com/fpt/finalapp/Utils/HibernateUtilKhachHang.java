/**
 * 
 */
package com.fpt.finalapp.Utils;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fpt.finalapp.entities.KhachHang;
import com.fpt.finalapp.entities.NhanVien;

/**
 * @author HCD-Fresher055
 *
 */
@Repository
public class HibernateUtilKhachHang {

	@Autowired
	private SessionFactory sessionFactory;

	public <T> void insertOrUpdate(final T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> T findById(Serializable id, Class<T> entityClass) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> fetchAll(Class<T> entityClass, int page) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		if (page == 1) {
			criteria.setFirstResult(0);
			criteria.setMaxResults(10);
			return criteria.list();
		} else {
			criteria.setFirstResult((page - 1) * 10);
			criteria.setMaxResults(10);
			return criteria.list();
		}
	}

	public <T> long countAllEntities(Class<T> entityClass) {
		return (Long) sessionFactory.getCurrentSession().createCriteria(entityClass)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	public <T> void deleteEntity(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> fetchAllEntities(Class<T> entityClass) {
		return (List<T>) sessionFactory.getCurrentSession().createCriteria(entityClass).list();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> searchByProperty(Class<T> entityClass, String property, String keySearch) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.like(property, keySearch));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> searchByPropertyKH(Class<T> entityClass, String keySearch) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.like(keySearch, entityClass));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getListEntitiesByProperties(Class<T> entityClass, String property, String value) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq(property, value));
		return criteria.list();
	}
	
	public List<KhachHang> getListKH() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT k FROM " + KhachHang.class.getName() + " k";
		Query query = session.createQuery(hql);
		return query.list();
	}
	public List<NhanVien> getListNV() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT n FROM " + NhanVien.class.getName() + " n";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
}
