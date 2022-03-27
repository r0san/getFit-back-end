package com.capstone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Exercise;


@Repository
public interface ExerciseRepository extends JpaRepository <Exercise, Integer> {

	
	//Query to find all cardio exercises:
	
	@Query ("SELECT E FROM Exercise E WHERE E.category = 'cardio'")
	List<Exercise> findCardioExercise();
	
	//Query to find all bodyweight exercises:
	
	@Query ("SELECT E FROM Exercise E WHERE E.category = 'body weight'")
	List<Exercise> findBodyWeightExercise(String category);

	


}
