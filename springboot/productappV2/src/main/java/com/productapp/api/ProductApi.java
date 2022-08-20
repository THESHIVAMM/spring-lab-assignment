package com.productapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.repository.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductApi {

	private ProductService productService;

	@Autowired
	public ProductApi(ProductService productService) {
		this.productService = productService;
	}
	@GetMapping(path = "products")
	public List<Product>findAll(){
		return productService.findAll();
	}
	
	@GetMapping(path = "products/{id}")
	public Product findById(@PathVariable(name = "id") int id){
		return productService.getById(id);
	}
	
	@PostMapping(path = "products")
	public Product addProduct( @RequestBody Product product){
		return productService.addProduct(product);
	}
	
	@DeleteMapping(path = "products/{id}")
	public Product deleteProduct(@PathVariable(name = "id") int id){
		return productService.deleteProduct(id);
	}
	
	@PutMapping(path = "products/{id}")
	public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product){
		return productService.updateProduct(id, product);
	}
}


