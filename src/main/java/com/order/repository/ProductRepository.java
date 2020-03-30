package com.order.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.order.entities.ProductEntity;

public class ProductRepository {
	
	private SessionFactory sessionFactory;
	
	public void save(ProductEntity product) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(product);
		session.getTransaction().commit();
		session.close();
		
	}

	public ProductEntity getById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		ProductEntity p = (ProductEntity) session.get(ProductEntity.class, id);
		
		session.getTransaction().commit();
		session.close();
		return p;
	}
	
	//public List<ProductEntity> getProductByCategoryName(){
	
	public ProductEntity getByName(String pname) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select p from ProductEntity p where p.name =:name");
		query.setParameter("name", pname);
		
		List<ProductEntity> products = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return products.get(0);
	}
	
	public List<ProductEntity> getByCategory(String category) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select p from ProductEntity p where p.category =:category");
		query.setParameter("category", category);
		
		List<ProductEntity> products = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return products;
	}
	
	public void update(ProductEntity product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(product);
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
