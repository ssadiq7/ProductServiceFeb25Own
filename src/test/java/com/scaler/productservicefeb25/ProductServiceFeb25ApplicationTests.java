package com.scaler.productservicefeb25;

import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.projections.ProductWithTitleAndPrice;
import com.scaler.productservicefeb25.repositories.CategoryRepository;
import com.scaler.productservicefeb25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceFeb25ApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
//		List<ProductWithTitleAndPrice> products =
//				productRepository.getProductTitleAndPriceSQL("Apple iPhone 14", 65000);
//
//		//System.out.println(products);
//		for (ProductWithTitleAndPrice product : products) {
//			System.out.println(product.getTitle() + " -> " + product.getPrice());
//		}

		// EAGER
		Optional<Product> optionalProduct = productRepository.findById(1L);
		// Hibernate: select p1_0.id,c1_0.id,c1_0.created_at,c1_0.is_deleted,c1_0.last_modified_at,c1_0.name,p1_0.created_at,p1_0.description,p1_0.image_url,p1_0.is_deleted,p1_0.last_modified_at,p1_0.price,p1_0.title from products p1_0 left join categories c1_0 on c1_0.id=p1_0.category_id where p1_0.id=?

		// LAZY
		Optional<Category> optionalCategory = categoryRepository.findById(1L);
		// Hibernate: select c1_0.id,c1_0.created_at,c1_0.is_deleted,c1_0.last_modified_at,c1_0.name from categories c1_0 where c1_0.id=?

	}

}
