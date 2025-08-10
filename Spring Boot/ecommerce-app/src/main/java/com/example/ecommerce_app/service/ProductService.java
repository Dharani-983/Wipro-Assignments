package com.example.ecommerce_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.model.Product;
import com.example.ecommerce_app.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}
