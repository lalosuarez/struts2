package org.lalosuarez.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.lalosuarez.app.dto.Tournament;
import org.lalosuarez.app.service.SessionFactoryService;

public class TournamentDaoImpl implements TournamentDao {

	private SessionFactoryService sessionFactoryService;

	@SuppressWarnings("unchecked")
	public List<Tournament> findAll() {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Tournament> list = null;
		
		try {
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Tournament.class);
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

	public void save(Tournament object) {
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
			System.out.println("CATCHED\n" + e.toString());
		} finally {
			session.close();
		}
	}

	public void remove(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();

		Tournament object = null;
		try {

			session.beginTransaction();

			object = (Tournament) session.get(Tournament.class, id);
			
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

	public Tournament find(int id) {
	    Session session = sessionFactoryService.getSessionFactory().openSession();
		
		Tournament object = null;
		
		try {
			session.beginTransaction();
			
			object = (Tournament) session.get(Tournament.class, id);
			
			//Avoids "failed to lazily initialize" error.
			Hibernate.initialize(object.getLeagues());
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return object;
	}

	@SuppressWarnings("unchecked")
	public List<Tournament> findByNumberOfResults(int start, int max) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Tournament> list = null;
		
		try {
			session.beginTransaction();
			
			Query query = session.createQuery("from Tournament");
			query.setFirstResult(start);
			query.setMaxResults(max);
			query.setCacheable(true);
			list = (List<Tournament>) query.list();
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Tournament> findByParameter(String searchParameter) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Tournament> list = null;
		
		try {
			session.beginTransaction();
			
			Query query = session.createQuery("SELECT t FROM Tournament t INNER JOIN t.leagues l "
				+ "WHERE t.name LIKE :searchParameter OR l.name LIKE :searchParameter");
			
			query.setString("searchParameter", "%" + searchParameter + "%");
			query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			query.setCacheable(true);

			list = (List<Tournament>) query.list();			
			
			/*	Criteria criteria = session.createCriteria(Tournament.class);
			
			criteria.createAlias("leagues", "l");
			This is for avoid duplicate results. 
			
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);			
			
			criteria.add(
			    Restrictions.or(
			    	Restrictions.like("name", "%" + searchParameter + "%"),
			    	Restrictions.like("l.name", "%" + searchParameter + "%")
			    )
			);
			
			criteria.setCacheable(true);
			
			list = (List<Tournament>) criteria.list(); */
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;		
	}
	
	public void setSessionFactoryService(SessionFactoryService sessionFactoryService) {
		this.sessionFactoryService = sessionFactoryService;
	}
}
