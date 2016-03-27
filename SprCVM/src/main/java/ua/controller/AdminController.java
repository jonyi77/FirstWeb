package ua.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	@RequestMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

}
