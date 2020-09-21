package com.microservices.app.invoices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.app.invoices.models.entity.Invoice;
import com.microservices.app.invoices.models.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Invoice> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Invoice> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Invoice save(Invoice invoice) {
		return repository.save(invoice);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
