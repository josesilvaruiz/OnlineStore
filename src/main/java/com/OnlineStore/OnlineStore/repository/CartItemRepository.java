package com.OnlineStore.OnlineStore.repository;

import org.springframework.data.repository.CrudRepository;
import com.OnlineStore.OnlineStore.models.entity.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

}
