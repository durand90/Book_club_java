package com.fanfan.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fanfan.bookclub.models.UserModel;

@Repository
public interface User extends CrudRepository<UserModel, Long> {
	
	List<UserModel> findAll();
	
	Optional<UserModel> findByEmail(String email);

}
