package com.microservices.app.business.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.business.models.entity.Business;
import com.microservices.app.business.services.BusinessService;

@RestController
public class BusinessController {
	@Autowired
	private BusinessService service;
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	//Ruta variable del ID a buscar
	@GetMapping("/{id}")
	public ResponseEntity<?> seeByID(@PathVariable Long id){
		Optional<Business> o = service.findById(id);
		if(o.isEmpty()) {
			//Body JSON vacio
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(o.get());
	}
	
	// Se envia la respuesta que se obtiene desde el body de entrada
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Business business){
		Business businessDB = service.save(business);
		return ResponseEntity.status(HttpStatus.CREATED).body(businessDB);
	}
	

	@DeleteMapping("({id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Business business, @PathVariable Long id){
		Optional<Business> o = service.findById(id);
		if(o.isEmpty()) {
			//Body JSON vacio
			return ResponseEntity.notFound().build();
		}
		
		Business bDb = o.get();
		bDb.setId(business.getId());
		bDb.setName(business.getName());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(bDb));
		
	}
}
