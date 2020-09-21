package com.microservices.app.invoices.services;

import java.util.Optional;

import com.microservices.app.invoices.models.entity.Invoice;

public interface InvoiceService {

	public Iterable<Invoice> findAll();
	
	public Optional<Invoice> findById(Long id);
	
	public Invoice save(Invoice invoice);
	
	public void deleteById(Long id);
}
