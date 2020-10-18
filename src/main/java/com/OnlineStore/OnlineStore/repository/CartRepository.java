package com.OnlineStore.OnlineStore.repository;

import org.springframework.data.repository.CrudRepository;

import com.OnlineStore.OnlineStore.models.entity.Cart;


public interface CartRepository extends CrudRepository<Cart, Long>{

}
