package com.order.Main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.order.entities.CategoryEntity;
import com.order.entities.ProductEntity;
import com.order.repository.CategoryRepository;
import com.order.repository.ProductRepository;

public class OneToMany {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		CategoryRepository cr = (CategoryRepository) ctx.getBean("categoryRepository");
		
		ProductRepository pr = (ProductRepository) ctx.getBean("productRepository");
		
//		CategoryEntity sporting = new CategoryEntity();
//		sporting.setName("Sports");
//		sporting.setDescription("This is sporting goods");
//		
//		cr.save(sporting);
		
		CategoryEntity elec = cr.getCategoryByName("Electronics");
		
		List<ProductEntity> products = elec.getProducts();
		for(ProductEntity p : products) {
			System.out.println(p.toString());
		}
		
		CategoryEntity sports = cr.getCategoryByName("Sports");
		
		ProductEntity p2 = new ProductEntity();
		p2.setName("basketball");
		p2.setDescription("brown in color mdeium size");
		
		p2.setCategory(sports);
		pr.save(p2);
		
//		ProductEntity p3 = new ProductEntity();
//		p3.setName("tennisball");
//		p3.setDescription("green in color small size");
//		p3.setCategory(sports);
//		
//		
//		sports.getProducts().add(p3);
//		cr.save(sports);
		
		
		
	}

}

	