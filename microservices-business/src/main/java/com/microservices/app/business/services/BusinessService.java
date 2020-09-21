package com.microservices.app.business.services;

import java.util.Optional;

import com.microservices.app.business.models.entity.Business;

public interface BusinessService {
	public Iterable<Business> findAll();
	
	public Optional<Business> findById(Long id);
	
	public Business save(Business business);
	
	public void deleteById(Long id);
}
