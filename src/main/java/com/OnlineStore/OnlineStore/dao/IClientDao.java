package com.OnlineStore.OnlineStore.dao;

import org.springframework.data.repository.CrudRepository;

import com.OnlineStore.OnlineStore.models.entity.Client;

public interface IClientDao extends CrudRepository<Client, Long>{



}
