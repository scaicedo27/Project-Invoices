package com.microservices.app.clients.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.clients.models.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
