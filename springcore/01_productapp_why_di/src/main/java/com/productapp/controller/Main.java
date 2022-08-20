package com.productapp.controller;

import java.math.BigDecimal;
import java.util.*;
import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class Main {
	public static void main(String[] args) {

		ProductService productService = new ProductServiceImpl();
		ArrayList<Product> arrayList = (ArrayList<Product>) productService.getAll();
		for(int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}

}
