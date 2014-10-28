package org.lalosuarez.app.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.lalosuarez.app.dto.User;

public class UserServiceImpl implements UserService {

	private SessionFactoryService sessionFactoryService;
	private Session session;
	
	public SessionFactoryService getSessionFactoryService() {
		return sessionFactoryService;
	}

	public void setSessionFactoryService(SessionFactoryService sessionFactoryService) {
		this.sessionFactoryService = sessionFactoryService;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		session = sessionFactoryService.getSessionFactory().openSession();
		List<User> list = null;
		try {
			session.beginTransaction();
			list = session.createCriteria(User.class).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return list;
	}

	public void save(User object) {
		
		User objectToSave = find(object.getUsername());
		
		session = sessionFactoryService.getSessionFactory().openSession();
		
		try {

			session.beginTransaction();
			
			if (objectToSave == null) {
				System.out.println("NUEVO");
				session.save(object);
			} else {
				System.out.println("UPDATE");
				session.update(object);
			}
			
			//session.save(object);
			
			session.getTransaction().commit();

		} catch (HibernateException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			session.close();

		}
		
	}

	public void remove(String username) {
		session = sessionFactoryService.getSessionFactory().openSession();

		User object = null;
		try {

			session.beginTransaction();

			object = (User) session.get(User.class, username);
			
			boolean status = true;

			if (object.isEnabled()) {
				status = false;
			}

			object.setEnabled(status);

			session.update(object);

			session.getTransaction().commit();

		} catch (HibernateException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			session.close();

		}
		
	}

	public User find(String username) {

		session = sessionFactoryService.getSessionFactory().openSession();
		User object = null;

		try {
			session.beginTransaction();
			object = (User) session.get(User.class, username);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return object;
	}
}
