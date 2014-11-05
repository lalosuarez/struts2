package org.lalosuarez.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.lalosuarez.app.dao.LeagueDao;
import org.lalosuarez.app.dto.League;
import org.lalosuarez.app.service.SessionFactoryService;

public class LeagueDaoImpl implements LeagueDao {

	private SessionFactoryService sessionFactoryService;
	
	@SuppressWarnings("unchecked")
	public List<League> findAll() {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<League> list = null;
		
		try {
			session.beginTransaction();
	
			Criteria criteria = session.createCriteria(League.class)
				.addOrder(Order.asc("name"));
			criteria.setCacheable(true);
			
			list = criteria.list();
			
			for (League object : list) {
				Hibernate.initialize(object.getTournaments());
			}	
							
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
			
		return list;
	}

	public void save(League object) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			if (object.getId() == 0) {
				session.save(object);
			} else {
				session.update(object);
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void remove(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();

		League object = null;
		try {

			session.beginTransaction();

			object = (League) session.get(League.class, id);
			
			boolean status = true;

			if (object.isActive()) {
				status = false;
			}

			object.setActive(status);

			session.update(object);

			session.getTransaction().commit();

		} catch (HibernateException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			session.close();

		}	
	}

	public League find(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		League object = null;
		
		try {
			session.beginTransaction();
			object = (League) session.get(League.class, id);
			
			//Avoids "failed to lazily initialize" error.
			//Hibernate.initialize(object.getTournaments());
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
			
		return object;
	}

	public void setSessionFactoryService(SessionFactoryService sessionFactoryService) {
		this.sessionFactoryService = sessionFactoryService;
	}

}
