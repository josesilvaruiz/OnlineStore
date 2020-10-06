package com.OnlineStore.OnlineStore.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineStore.OnlineStore.dao.IClientDao;
import com.OnlineStore.OnlineStore.models.entity.Client;

@Service
public class ClientServiceImpl implements IClienteService {

	@Autowired
	private IClientDao clientDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}

	@Override
	@Transactional
	public void save(Client client) {
		clientDao.save(client);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Client findOne(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDao.deleteById(id);
		
	}
}
