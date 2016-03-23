package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.Role;
import ua.entity.User;
import ua.service.impl.UserServiceImpl;

@Controller
public class AdminController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/admin")
	public String showAdmin(Model model, Principal principal) {
		if (principal != null) {
			User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
			if (Role.ROLE_ADMIN == user.getRole()) {
				model.addAttribute("user", user);
				return "admin";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}

	}

}
