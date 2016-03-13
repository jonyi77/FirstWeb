package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.ColorServiceImpl;

@Controller
public class ColorController {
	
	@Autowired
	private ColorServiceImpl colorServiceImpl;
	
	@RequestMapping("/color")
	public String colorView(Model model){
		model.addAttribute("colors", colorServiceImpl.getAll());
		return "color";
	}
	
	@RequestMapping(value="/color", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		colorServiceImpl.save(name);
		return "redirect:/color";
	}
	@RequestMapping("/color/{id}")
	public String delete(@PathVariable String id){
		colorServiceImpl.delete(id);
		return "redirect:/color";
	}

}
