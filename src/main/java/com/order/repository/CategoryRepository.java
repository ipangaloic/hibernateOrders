package com.order.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.order.entities.CategoryEntity;

public class CategoryRepository {
	
	private SessionFactory sessionFactory;
	
	public void save (CategoryEntity categoryEntity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(categoryEntity);
		session.getTransaction().commit();
		session.close();
		
	}

	public CategoryEntity getCategoryByName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select c from CategoryEntity c where c.name =:name");
		query.setParameter("name", name);
		
		List<CategoryEntity> category = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return category.get(0);
		
	}
	
	public void update(CategoryEntity c) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(c);
		session.getTransaction().commit();
		session.close();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
