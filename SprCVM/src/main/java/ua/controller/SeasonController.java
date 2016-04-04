package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Role;
import ua.entity.Season;
import ua.entity.User;
import ua.service.binder.SeasonEditor;
import ua.service.impl.SeasonServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class SeasonController {

	@Autowired
	private SeasonServiceImpl seasonServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Season.class, new SeasonEditor(seasonServiceImpl));
	}

	@RequestMapping("/admin/season")
	public String seasonView(Model model, Principal principal) {
		if (principal != null) {
			User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
			if (Role.ROLE_ADMIN == user.getRole()) {
				model.addAttribute("user", user);
				model.addAttribute("seasons", seasonServiceImpl.getAll());
				model.addAttribute("season", new Season());
				return "season";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}
	}

	// @RequestMapping(value="/season", method=RequestMethod.POST)
	// public String save(@RequestParam String name){
	// seasonServiceImpl.save(name);
	// return "redirect:/season";
	// }

	@RequestMapping(value = "/admin/season", method = RequestMethod.POST)
	public String save(@ModelAttribute Season season) {
		seasonServiceImpl.editSeason(season);
		return "redirect:/admin/season";
	}

	@RequestMapping("/admin/season/{id}")
	public String delete(@PathVariable String id) {
		seasonServiceImpl.delete(id);
		return "redirect:/admin/season";
	}

	@RequestMapping("/admin/season/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("season", seasonServiceImpl.findById(Integer.parseInt(id)));
		return "season";
	}

}
