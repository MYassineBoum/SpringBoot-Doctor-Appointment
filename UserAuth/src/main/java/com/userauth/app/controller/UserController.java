package com.userauth.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userauth.app.model.User;
import com.userauth.app.repository.UserRepository;
import com.userauth.app.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	@GetMapping("/editProfile")
	public String editProfile() {
		return "editProfile";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		User newUser = new User();
		model.addAttribute("user", newUser);
		return "register";
	}
	
	@PostMapping("/success")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/success";
	}
	
	@GetMapping("/account")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("userLogin", user);
		return "login";
	}
	
	@PostMapping("/loginProcess")
	public String loginSuccess(@ModelAttribute("userLogin") User user) {
		String userID = user.getId();
		Optional<User> userFound = userRepository.findById(userID);
		if(user.getPassword().equals(userFound.get().getPassword())) {
			return "editProfile";
		}
		else {
			return "home";
		}
	}
}
