package com.fanfan.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fanfan.bookclub.models.BookModel;
import com.fanfan.bookclub.models.UserModel;
import com.fanfan.bookclub.services.BookService;
import com.fanfan.bookclub.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookServ;
	@Autowired
	UserService userServ;
	
	@GetMapping("/books")
	public String books(@ModelAttribute("books") BookModel book, Model model, HttpSession session) {
		
		//route guard
		Long userId = (Long) session.getAttribute("user_id");
		//check if userId is null
		if (userId == null ) {
			return "redirect:/";
		} else {
		
		// pass in logged in user
		UserModel loggedInUser = userServ.findUser(userId);
			
		List<BookModel> allBooks = bookServ.allBooks();
		
		model.addAttribute("allBooks", allBooks);
		model.addAttribute("logUser", loggedInUser);
		return "/books/books.jsp";
	}
	}
	
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("books") BookModel book, BindingResult result) {
		if(result.hasErrors()) {
			return "/books/books.jsp";
		}
		else {
			bookServ.createBook(book);
			
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model) {
		
		BookModel oneBook = bookServ.findBook(id);
		model.addAttribute("books", oneBook);
		return "books/editBook.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public String updateBook(@Valid @ModelAttribute("books") BookModel book, BindingResult result) {
		if (result.hasErrors()) {
			return "books/editBook.jsp";
		}
		else {
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}
	
	@RequestMapping("/books/{id}/show")
	public String showBook(@PathVariable("id") Long id, Model model) {
		
		BookModel getOne = bookServ.findBook(id);
		model.addAttribute("book", getOne);
		return "";
	}

}
