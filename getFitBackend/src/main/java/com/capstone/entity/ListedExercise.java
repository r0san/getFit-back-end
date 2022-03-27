package com.capstone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name = "list")
public class ListedExercise {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
//	
//	@ManyToMany
//	
//	@JoinTable (name = "list", joinColumns = @JoinColumn (name = "exercise_id"), inverseJoinColumns = @JoinColumn (name = "id"))
	
	@Column (name = "exercise_id")
	private int exerciseId ;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
	
	@Column (name = "user_id")
	private int userId;
	
public ListedExercise() {
		
	}

	public ListedExercise(int id, int exerciseId, int userId) {
		
		this.id = id;
		this.exerciseId = exerciseId;
		this.userId = userId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
	
	
	

}
