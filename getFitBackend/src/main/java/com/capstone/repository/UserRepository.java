package com.capstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.entity.User;

@Repository
public interface UserRepository extends  JpaRepository <User, Integer> {
	
	//Query for login:
	@Query ("SELECT U FROM User U WHERE U.email =?1 AND U.password =?2")
	User signIn (String email, String password);

	
	//Query for finding user by email:
	@Query ("SELECT U FROM User U WHERE U.email =?1")
	Optional<User> findByEmail (String email);
	
}
