package com.hruse.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hruse.entities.User;
import com.hruse.repositories.UserRepository;



@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {		
		Optional<User> user = userRepository.findById(id);
		return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();	
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {		
		User emailUser = userRepository.findByEmail(email);
		return ResponseEntity.ok(emailUser);	
	}
}
