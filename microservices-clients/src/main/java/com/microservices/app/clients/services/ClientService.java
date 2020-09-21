package com.microservices.app.clients.services;

import java.util.Optional;

import com.microservices.app.clients.models.entity.Client;


public interface ClientService {
	public Iterable<Client> findAll();
	
	public Optional<Client> findById(Long id);
	
	public Client save(Client client);
	
	public void deleteById(Long id);
}

