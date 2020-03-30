package com.order.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.order.entities.ProductEntity;
import com.order.repository.ProductRepository;

public class InsertMainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		ProductRepository pr = (ProductRepository) ctx.getBean("productRepository");
		
		ProductEntity p = new ProductEntity();
		p.setName("Iphone 11 pro");
		p.setDescription("Electronics");
		pr.save(p);	
	
	}

}
