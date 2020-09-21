package com.microservices.app.clients.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.app.clients.models.entity.Client;
import com.microservices.app.clients.models.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Client> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Client> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Client save(Client client) {
		return repository.save(client);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


	

}
