package com.OnlineStore.OnlineStore.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.OnlineStore.OnlineStore.models.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	
}
