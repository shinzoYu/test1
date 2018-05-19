package com.demopackage.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demopackage.model.User;

@Repository("demoRepository")
public class DemoRepositoryImpl implements DemoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean insert(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(user);
			sessionFactory.getCurrentSession().flush();
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean delete(String userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("delete User where userId = :userId");
			query.setParameter("userId", Integer.valueOf(userId));
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> getAll() {
		try {
//			Query query = this.sessionFactory.getCurrentSession().createQuery(" from User");
			Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(User.class);
			return criteria.list();
		} catch (Exception e) {
			return new ArrayList<User>();
		}
	}

}
