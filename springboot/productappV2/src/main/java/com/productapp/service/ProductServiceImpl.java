package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.repository.Product;
import com.productapp.repository.ProductDao;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	private ProductDao productDao;
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public List<Product> findAll() {
		
		return productDao.findAll();
	}

	public Product getById(int id) {
		
		return productDao.findById(id).orElseThrow(() -> new ProductNotFoundException("product with id" + id + " is not found"));
	}

	public Product addProduct(Product product) {
		
		productDao.save(product);
		return product;
	}

	public Product updateProduct(int id, Product product) {
		
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

	public Product deleteProduct(int id) {
		
		Product productToDelete= getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}

}
