package com.fanfan.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fanfan.bookclub.models.BookModel;

public interface Book extends CrudRepository<BookModel, Long> {
	
	List<BookModel> findAll();

}
