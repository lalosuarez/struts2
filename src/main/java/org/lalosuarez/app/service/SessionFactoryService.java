package org.lalosuarez.app.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryService {
	
	private final SessionFactory sessionFactory;

	public SessionFactoryService() {
	    Configuration configuration = new Configuration().configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
