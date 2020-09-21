package com.microservices.app.business.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.business.models.entity.Business;

public interface BusinessRepository extends CrudRepository<Business, Long> {

}
