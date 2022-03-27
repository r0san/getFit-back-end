package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.ListedExercise;

@Repository
public interface ListedExerciseRepository extends JpaRepository <ListedExercise, Integer> {

	
	
	

}
