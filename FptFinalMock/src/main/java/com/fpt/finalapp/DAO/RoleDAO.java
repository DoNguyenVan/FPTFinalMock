package com.fpt.finalapp.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fpt.finalapp.entities.Role;

@Repository
public class RoleDAO {
	@Autowired
    private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	public List<Role> listG() {
		String sql = "Select new " + Role.class.getName()//
			+ "(a.idRole, a.nameRole) "//
				+ " from " + Role.class.getName() + " a ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}
}
