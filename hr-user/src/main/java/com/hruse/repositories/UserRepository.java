package com.hruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hruse.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
