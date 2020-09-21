package com.microservices.app.business.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.app.business.models.entity.Business;
import com.microservices.app.business.models.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements BusinessService {
	
	@Autowired
	private BusinessRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Business> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Business> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public Business save(Business business) {
		return repository.save(business);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
