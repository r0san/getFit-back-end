package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table (name = "exercise")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, 
property = "id")

public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "category")
	private String category;
	
	@Column (name = "muscle_group")
	private String muscleGroup;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "reps")
	private String reps;
	
	@Column (name = "intensity")
	private String intensity;
	
	 @Lob 
	@Column (name ="pics")
	private byte [] pics;
	
public Exercise() {
		
	}

	public Exercise(int id, String name, String category, String muscleGroup, String description, String reps,
			String intensity, byte[] pics) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.muscleGroup = muscleGroup;
		this.description = description;
		this.reps = reps;
		this.intensity = intensity;
		this.pics = pics;
	}
   
	@Transient
	public String getExerciseImage () {
		return "data:image/png;base64," + Base64.encodeBase64String(pics);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public byte[] getPics() {
		return pics;
	}

	public void setPics(byte[] pics) {
		this.pics = pics;
	}

	
	
}
