package com.OnlineStore.OnlineStore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.repository.ProductRepository;
@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public List<Product> findAll () {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
