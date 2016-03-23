package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/login")
	public String userView(Model model){
		return "login";
	}
	@RequestMapping("/registration")
	public String registrationView(Model model){
		return "registration";
	}
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String save(@RequestParam String name, String login, String phone, String email, String password){
		userServiceImpl.save(name, login, phone, email, password);
		return "redirect:/registration";
	}

}
