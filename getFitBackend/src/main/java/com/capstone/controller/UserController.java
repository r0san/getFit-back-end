package com.capstone.controller;
import java.util.Optional;
import org.springframework.boot.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.entity.Address;
import com.capstone.entity.User;
import com.capstone.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	
	
	@RequestMapping (value = "/sign-up",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
public void userDetails (@RequestBody User user) {
		userRepository.save(user);
	}
	
	
	//finding user by email:
	@RequestMapping (value = "/findUserByEmail",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	
	@ResponseBody
	private ResponseEntity<Optional<User>> findUser (String email){
		Optional<User> user = userRepository.findByEmail(email);
		return new ResponseEntity<> (user, HttpStatus.OK);
	}
	
	// finding user by id:
	@RequestMapping (value = "/findUserById",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	
	@ResponseBody
	private ResponseEntity<Optional<User>> findUser (int id){
		Optional<User> user = userRepository.findById(id);
		return new ResponseEntity<> (user, HttpStatus.OK);
	}
	
	

		
	
	//Sign-In logic:
	
	@RequestMapping (value = "/sign-in",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	
	@ResponseBody
	private ResponseEntity<User> signInUser (@RequestBody User user){
	User signInUser = userRepository.signIn (user.getEmail(), user.getPassword());
	
	if (signInUser != null) {
	return new ResponseEntity<>(signInUser, HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	}
	
//	@RequestMapping (value = "/save/upload",
//			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE,
//			method = RequestMethod.POST)
//public void uploadFile (@RequestParam ("File") MultipartFile file, @RequestParam ("firstName" )String firstName,
//		@RequestParam ("street") String street) {
//		User user = new User ();
//		user.setFirstName(firstName);
//		
//		Address address = new Address ();
//		address.setStreet(street);
//		user.setAddress(address);
//		userRepository.save(user);
//	}
	
	
	
}
