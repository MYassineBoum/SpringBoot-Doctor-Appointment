package com.userauth.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userauth.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
		
}
