package com.example.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mysql.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// @Query("SELECT * FROM User where email=:email")
	// public Single<User> findUserEmal(@Param("email") String email);

	// public Single<User> findByNameUser(String name);
	// public Optional<User> findByUserId(int id);
	// Optional<User> findUserById(int id);

}
