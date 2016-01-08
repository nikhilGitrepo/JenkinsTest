package org.marist.sdd.projects.transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.marist.sdd.projects.pojo.URLDuo;
import org.marist.sdd.projects.util.HibernateUtil;
import org.springframework.stereotype.Repository;

@Repository("TransactionDao")
public class TransactionManager extends HibernateUtil implements TransactionManagerDao {

	public TransactionManager() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getRecentUrl() {
		Session session = getSession();
		List<String> urls = new ArrayList<String>();
		try{
			session.getTransaction().begin();
			Criteria cr = session.createCriteria(URLDuo.class);
			cr.setProjection(Projections.property("shortUrl"));
			cr.addOrder((Order.desc("dateCreated")));
			cr.setMaxResults(10);
			urls = cr.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	

		return urls;
	}

	@Override
	public boolean addUrl(URLDuo url) {

		Session session = getSession();
		try {
			session.getTransaction().begin();

			session.saveOrUpdate(url);
			
			session.getTransaction().commit();
			
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();			
		}
		return false;
		
	}

	@Override
	public List<URLDuo> loadAllUrl() {
		List<URLDuo> allUrl = new ArrayList<URLDuo>();
		
		Session session = getSession();
		try {
			session.getTransaction().begin();

			Query query = session.getNamedQuery("findAllUrlsINDatabase");
			allUrl = (List<URLDuo>) query.list();
			session.getTransaction().commit();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return allUrl;
	}

	@Override
	public List<String> loadAllDesiredId() {
		List<String> allDesiredId = new ArrayList<String>();
		Session session = getSession();
		try{
			session.getTransaction().begin();
			Criteria cr = session.createCriteria(URLDuo.class);
			cr.setProjection(Projections.property("desiredId"));
			allDesiredId = cr.list();
		}catch(RuntimeException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return allDesiredId;
	}
	
}
