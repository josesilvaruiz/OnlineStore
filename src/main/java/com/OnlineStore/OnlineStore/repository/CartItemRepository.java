package com.OnlineStore.OnlineStore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineStore.OnlineStore.models.entity.CartItem;
@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

}
