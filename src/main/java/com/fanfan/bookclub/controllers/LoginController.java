package com.fanfan.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanfan.bookclub.models.LoginUser;
import com.fanfan.bookclub.models.UserModel;
import com.fanfan.bookclub.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userServ;
	
	//render login/ register page
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new UserModel());
		model.addAttribute("newLogin", new LoginUser());
		return "login/index.jsp";
	}
	
	
	
	//register new user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") UserModel user, BindingResult result, Model model,
							HttpSession sess) {
		//before checking for errors, execute the Service to register first
		userServ.register(user, result);
		
		//then check for errors
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login/index.jsp";
		} else {
			sess.setAttribute("user_id", user.getId());
			return "redirect:/books";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser login, BindingResult result,
							Model model, HttpSession sess) {
		
		UserModel user = userServ.login(login, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new UserModel());
			return "login/index.jsp";
		} else {
			sess.setAttribute("user_id", user.getId() );
			return "redirect:/books";
		}
		
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}

	
	@RequestMapping("/home")
	public String home(HttpSession s, Model model) {
		//retrieve user from session
		Long userId = (Long) s.getAttribute("user_id");
		//check if user is null
		if(userId == null) {
			return "redirect:/";
		} else {
			//go to the database to retrieve the user using id from session
			UserModel thisUser = userServ.findUser(userId);
			return "login/home.jsp";
		}
	}
}
