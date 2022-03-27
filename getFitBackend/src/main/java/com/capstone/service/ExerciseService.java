package com.capstone.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.entity.Exercise;
import com.capstone.repository.ExerciseRepository;

@Service
public class ExerciseService {

	@Autowired
	ExerciseRepository exerciseRepository;

	public void saveImage(MultipartFile imageFile, Exercise exercise) {
		try {
			byte[] imageBytes = imageFile.getBytes();
			
			exercise.setPics(imageBytes);
			exerciseRepository.save(exercise);
		} catch (IOException e) {
			System.out.print("error");

		}

	}
}
