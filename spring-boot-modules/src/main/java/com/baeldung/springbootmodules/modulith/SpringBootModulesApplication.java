package com.baeldung.springbootmodules.modulith;

import com.baeldung.springbootmodules.modulith.product.ProductService;
import com.baeldung.springbootmodules.modulith.product.internal.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootModulesApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootModulesApplication.class, args)
				.getBean(ProductService.class)
				.create(new Product("jj-training", "good-training", 100));
	}

}
