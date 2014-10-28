package org.lalosuarez.app.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.lalosuarez.app.dto.Role;

public class RoleServiceImpl implements RoleService {

	private SessionFactoryService sessionFactoryService;
	private Session session;
	
	public SessionFactoryService getSessionFactoryService() {
		return sessionFactoryService;
	}

	public void setSessionFactoryService(SessionFactoryService sessionFactoryService) {
		this.sessionFactoryService = sessionFactoryService;
	}

	@SuppressWarnings("unchecked")
	public List<Role> findAll() {
		
		session = sessionFactoryService.getSessionFactory().openSession();
		List<Role> list = null;
		
		try {
			session.beginTransaction();
			list = session.createCriteria(Role.class).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return list;
	}

	public void save(Role object) {
		// TODO Auto-generated method stub
		
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	public Role find(int id) {

		session = sessionFactoryService.getSessionFactory().openSession();
		Role object = null;

		try {
			session.beginTransaction();
			object = (Role) session.get(Role.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("EXCEPTION");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return object;
	}

}
