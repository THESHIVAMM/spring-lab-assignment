package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.repository.Product;
import com.productapp.repository.ProductDao;

@SpringBootApplication
public class Productappv1Application implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Productappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productDao.save(new Product("laptop", new BigDecimal(1000000)));
		productDao.save(new Product("printer", new BigDecimal(100000)));
	}
}
