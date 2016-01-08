package org.marist.sdd.projects.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateUtil {
	
	public HibernateUtil() {
	}

	@Autowired
	private SessionFactory sessionFactory;
	 
    protected synchronized Session getSession() {
    	if(sessionFactory.getCurrentSession() == null){
    		return sessionFactory.openSession();
    	}
        return sessionFactory.getCurrentSession();
    }
 
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
	
}
