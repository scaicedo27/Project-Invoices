package com.microservices.app.invoices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.microservices.app.business.models.entity",
	"com.microservices.app.invoices.models.entity", 
	"com.microservices.app.clients.models.entity"})
public class MicroservicesInvoicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesInvoicesApplication.class, args);
	}

}
