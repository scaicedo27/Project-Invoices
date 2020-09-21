package com.microservices.app.invoices.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.invoices.models.entity.Invoice;
import com.microservices.app.invoices.services.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceService service;
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	//Ruta variable del ID a buscar
	@GetMapping("/{id}")
	public ResponseEntity<?> seeById(@PathVariable Long id){
		Optional<Invoice> o = service.findById(id);
		if(o.isEmpty()) {
			//Body JSON vacio
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(o.get());
	}
	
	// Se envia la respuesta que se obtiene desde el body de entrada
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Invoice invoice){
		Invoice transaccionDb = service.save(invoice);
		return ResponseEntity.status(HttpStatus.CREATED).body(transaccionDb);
	}
	

	@DeleteMapping("({id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
