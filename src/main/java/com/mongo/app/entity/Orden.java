package com.mongo.app.entity;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ordenes")
public class Orden {
	
	
	
	public Orden(Integer id, Date registerDay, String status, Usuario salesMan, Map<String, Producto> products,
			Map<String, Integer> quantities) {
		
		this.id = id;
		this.registerDay = registerDay;
		this.status = status;
		this.salesMan = salesMan;
		this.products = products;
		this.quantities = quantities;
	}
	
	public Orden() {
		
	}

	public static String PENDING = "Pendiente";

	public static String APROVED = "Aprobada";

	public static String REJECTED = "Rechazada";

	@Id
	private Integer id;

	private Date registerDay;

	private String status;

	private Usuario salesMan;
	
	private Map<String, Producto> products;

	private Map<String, Integer> quantities;
	
	
	
	// Getters and Setters
	
	public static String getPENDING() {
		return PENDING;
	}

	public static void setPENDING(String pENDING) {
		PENDING = pENDING;
	}

	public static String getAPROVED() {
		return APROVED;
	}

	public static void setAPROVED(String aPROVED) {
		APROVED = aPROVED;
	}

	public static String getREJECTED() {
		return REJECTED;
	}

	public static void setREJECTED(String rEJECTED) {
		REJECTED = rEJECTED;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRegisterDay() {
		return registerDay;
	}

	public void setRegisterDay(Date registerDay) {
		this.registerDay = registerDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getSalesMan() {
		return salesMan;
	}

	public void setSalesMan(Usuario salesMan) {
		this.salesMan = salesMan;
	}

	public Map<String, Producto> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Producto> products) {
		this.products = products;
	}

	public Map<String, Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(Map<String, Integer> quantities) {
		this.quantities = quantities;
	}

	

}
