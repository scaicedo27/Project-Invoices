package com.microservices.app.invoices.models.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.microservices.app.business.models.entity.Business;
import com.microservices.app.clients.models.entity.Client;

@Entity
@Table(name="invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_invoice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_business", referencedColumnName = "id")
	private Business business;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client", referencedColumnName = "id_client")
	private Client persona;
	
	private int	value;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	public Long getId_invoice() {
		return id_invoice;
	}

	public void setId_invoice(Long id_invoice) {
		this.id_invoice = id_invoice;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Client getPersona() {
		return persona;
	}

	public void setPersona(Client persona) {
		this.persona = persona;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	

}
