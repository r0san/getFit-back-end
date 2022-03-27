package com.capstone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table (name="user")


public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "user_id")
	private int id;
	
	@Column (name = "first_name")
	private String firstName;
	
	@Column (name = "last_name")
	private String lastName;
	
	@Column (name = "age")
	private int age;
	
	@Column (name = "phone_number")
	private int phoneNumber;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "address_id")
	private Address address;
	
	@ManyToMany
	@JoinTable (name = "list", joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn (name = "exercise_id"))
	private List<Exercise> exercise;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "password")
	private String password;
	
public User() {
		
	}

	public User(int id, String firstName, String lastName, int age, int phoneNumber, Address address, String email,
			String password) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public List<Exercise> getExercise() {
		return exercise;
	}

	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}
	

}
