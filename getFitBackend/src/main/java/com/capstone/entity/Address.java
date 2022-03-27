package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "address")
public class Address {
	@Id
	@Column (name ="id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name ="street")
	private String street;
	
	@Column (name ="state")
	private String state;
	
	@Column (name = "zip")
	private int zip;
	
	@Column (name = "city")
	private String city;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address() {
		super();
	}

	public Address(int id, String street, String state, int zip, String city) {
		
		this.id = id;
		this.street = street;
		this.state = state;
		this.zip = zip;
		this.city = city;
	}

}
