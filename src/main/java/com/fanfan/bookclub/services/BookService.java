package com.fanfan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanfan.bookclub.models.BookModel;
import com.fanfan.bookclub.repositories.Book;

@Service
public class BookService {
	
	@Autowired
	Book bookRepo;
	
	public List<BookModel> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public BookModel createBook(BookModel b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBookModel = bookRepo.findById(id);
        if(optionalBookModel.isPresent()) {
            return optionalBookModel.get();
        } else {
            return null;
        }
    }
    public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
    }
		
		public BookModel updateBook(BookModel b) {
			return bookRepo.save(b);
		}


}
