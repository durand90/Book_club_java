package com.fanfan.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fanfan.bookclub.models.LoginUser;
import com.fanfan.bookclub.models.UserModel;
import com.fanfan.bookclub.services.UserService;

@Controller
public class UserController {

	

	@Autowired
	UserService userServ;
	
	@GetMapping("/users")
	public String newUser(Model model) {
		
		model.addAttribute("newUser", new UserModel());
		model.addAttribute("newLogin", new  LoginUser());
		return "users.jsp";
	}
	
	
	
}
