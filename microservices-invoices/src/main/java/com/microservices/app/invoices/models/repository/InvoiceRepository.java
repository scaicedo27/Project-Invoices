package com.microservices.app.invoices.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.invoices.models.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
