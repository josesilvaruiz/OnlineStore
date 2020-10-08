package com.OnlineStore.OnlineStore.dao;

import org.springframework.data.repository.CrudRepository;

import com.OnlineStore.OnlineStore.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{
	
	public User findbyUsername(String email);
}
