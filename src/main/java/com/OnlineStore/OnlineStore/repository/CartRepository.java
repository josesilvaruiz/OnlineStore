package com.OnlineStore.OnlineStore.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineStore.OnlineStore.models.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}
