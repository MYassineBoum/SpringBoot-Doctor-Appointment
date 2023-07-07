package com.userauth.app.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.userauth.app.model.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
		
}
