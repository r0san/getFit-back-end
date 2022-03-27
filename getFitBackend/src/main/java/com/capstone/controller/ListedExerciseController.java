package com.capstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Exercise;
import com.capstone.entity.ListedExercise;

import com.capstone.entity.User;
import com.capstone.repository.ExerciseRepository;
import com.capstone.repository.ListedExerciseRepository;
import com.capstone.repository.UserRepository;

@CrossOrigin
@RestController
public class ListedExerciseController {
	
	@Autowired
	ListedExerciseRepository listedExerciseRepository;
	
	@Autowired
	ExerciseRepository exerciseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	//logic to add exercise to list:
	@RequestMapping (value = "/saveList",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	@ResponseBody
	public void addToList (@RequestBody ListedExercise listedExercise) {
//		ListedExercise tempList = new ListedExercise ();
//		User tempUser = userRepository.findByEmail(listedExercise.getUser().getEmail()).get();
////		List<Exercise> tempExercise = exerciseRepository.findById(listedExercise.getExercise().get(id)).get();
//		tempList.setUser(tempUser);
//		tempList.setExercise(listedExercise.getExercise());
		listedExerciseRepository.save(listedExercise);
	}

	
	//logic to view plan
		
		@RequestMapping (value ="/viewList",
				produces = MediaType.APPLICATION_JSON_VALUE,
				method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<List<ListedExercise>> findAllList (){
			List<ListedExercise> listedExercise = listedExerciseRepository.findAll();
			return new ResponseEntity <>(listedExercise, HttpStatus.OK);
		}
	

}
