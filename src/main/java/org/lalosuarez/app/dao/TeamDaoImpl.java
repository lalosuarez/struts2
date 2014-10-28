package org.lalosuarez.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.lalosuarez.app.dto.Team;
import org.lalosuarez.app.service.SessionFactoryService;

public class TeamDaoImpl implements TeamDao {
	private SessionFactoryService sessionFactoryService;

	@SuppressWarnings("unchecked")
	public List<Team> findAll() {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Team> list = null;
		
		try {
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Team.class);
			criteria.setCacheable(true);
			list = criteria.list();
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return list;
	}

	public void save(Team object) {
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

		Team object = null;
		
		try {
			session.beginTransaction();
			object = (Team) session.get(Team.class, id);
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

	public Team find(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		Team object = null;
		
		try {
			session.beginTransaction();
			object = (Team) session.get(Team.class, id);
			Hibernate.initialize(object.getLeague());
			/*			Hibernate.initialize(object.getLeague().getTournaments());*/
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
