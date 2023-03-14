package com.empPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empPortal.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	  public User findByUsername(String username); 
}
