package com.capstone.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.entity.Exercise;
import com.capstone.repository.ExerciseRepository;
import com.capstone.service.ExerciseService;

@CrossOrigin
@RestController
public class ExerciseController {

	@Autowired
	ExerciseRepository exerciseRepository;

	@Autowired
	ExerciseService exerciseService;

	@RequestMapping(value = "/listExecise", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Exercise>> findAllExercise() {
		List<Exercise> exerciseList = exerciseRepository.findAll();
		return new ResponseEntity<>(exerciseList, HttpStatus.OK);
	}

	@RequestMapping(value = "/exerciseById", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	private ResponseEntity<Optional<Exercise>> findExerciseById(Integer id) {
		Optional<Exercise> exercise = exerciseRepository.findById(id);
		return new ResponseEntity<>(exercise, HttpStatus.OK);
	}

	// finding Cardio exercises:
	@RequestMapping(value = "/cardioExercises", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)

	@ResponseBody
	private ResponseEntity<List<Exercise>> findCardioExercise() {
		List<Exercise> listCardioExercise = exerciseRepository.findCardioExercise();
		return new ResponseEntity<>(listCardioExercise, HttpStatus.OK);
	}

	// finding Body Weight exercises:
	@RequestMapping (value = "/bodyWeightExercises",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	
	@ResponseBody
	private ResponseEntity <List<Exercise>> findBodyWeightExercise ( String category){
		List<Exercise> listBodyWeightExercise = exerciseRepository.findBodyWeightExercise(category);
		return new ResponseEntity <> (listBodyWeightExercise, HttpStatus.OK);
	}

	
	
	// Logic to add exercise:
	
	@RequestMapping (value = "/saveExercise",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	
	public void addExercise (@RequestBody Exercise exercise) {
             exerciseRepository.save(exercise);
	}
	
	
	//Logic to add image:
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/images", method = RequestMethod.POST)

	@ResponseBody
	public ResponseEntity saveImage(MultipartFile imageFile, Exercise exercise) {
		exerciseRepository.save(exercise);
		exerciseService.saveImage(imageFile, exercise);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
