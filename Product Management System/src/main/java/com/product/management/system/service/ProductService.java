package com.product.management.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.management.system.entity.ProductEntity;
import com.product.management.system.repository.ProductRepository;

@Service

public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;


	public List<ProductEntity> listAll() {
		return productRepository.findAll();
	}


	public void save(ProductEntity productEntity) {
		productRepository.save(productEntity);
	}


	public ProductEntity getProductBasedOnId(int id) {
		return productRepository.findById((long) id).get();
	}


	public void deleteBasedOnId(int id) {
		productRepository.deleteById((long) id);
		
	}

}
