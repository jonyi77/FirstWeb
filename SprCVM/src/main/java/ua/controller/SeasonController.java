package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.SeasonServiceImpl;

@Controller
public class SeasonController {
	
	@Autowired
	private SeasonServiceImpl seasonServiceImpl;
	
	@RequestMapping("/season")
	public String seasonView(Model model){
		model.addAttribute("seasons", seasonServiceImpl.getAll());
		return "season";
	}
	@RequestMapping(value="/season", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		seasonServiceImpl.save(name);
		return "redirect:/season";
	}
	@RequestMapping("/season/{id}")
	public String delete(@PathVariable String id){
		seasonServiceImpl.delete(id);
		return "redirect:/season";
	}

}
