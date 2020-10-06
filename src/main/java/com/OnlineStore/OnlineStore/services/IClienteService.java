package com.OnlineStore.OnlineStore.services;

import java.util.List;

import com.OnlineStore.OnlineStore.models.entity.Client;

public interface IClienteService {
	
	public List<Client> findAll();

	public void save(Client client);
	
	public Client findOne(Long id);
	
	public void delete(Long id);
	
}
