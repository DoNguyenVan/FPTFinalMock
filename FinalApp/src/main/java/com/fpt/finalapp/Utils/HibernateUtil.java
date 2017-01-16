/**
 * 
 */
package com.fpt.finalapp.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HCD-Fresher055
 *
 */
@Repository
@Transactional
public class HibernateUtil {

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
		List<T> result = new ArrayList<T>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.like(property, keySearch + "%"));
		if (criteria.list() != null) {
			result = (List<T>) criteria.list();
		}
		return result;
	}

	public <T> double countAllRowOfColumn(Class<T> entityClass, String property, String value, String column) {
		double result = 0;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.like(property, value + "%"));
		criteria.setProjection(Projections.sum(column));
		if (criteria.uniqueResult() != null) {
			result = (double) criteria.uniqueResult();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getListBetween(Class<T> entityClass,String property, Date beginDate, Date endDate) {
		List<T> result = new ArrayList<T>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.between(property,beginDate, endDate));
		if(criteria.list()!=null) {
			result=criteria.list();
		}
		return result;
	}
	

}
