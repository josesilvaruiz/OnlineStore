package com.OnlineStore.OnlineStore.repository;

import org.springframework.data.repository.CrudRepository;

import com.OnlineStore.OnlineStore.models.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
