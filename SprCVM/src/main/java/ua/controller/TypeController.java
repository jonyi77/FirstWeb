package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.TypeServiceImpl;

@Controller
public class TypeController {
	
	@Autowired
	private TypeServiceImpl typeServiceImpl;
	
	@RequestMapping("/type")
	public String typeView(Model model){
		model.addAttribute("types", typeServiceImpl.getAll());
		return "type";
	}
	@RequestMapping(value="/type", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		typeServiceImpl.save(name);
		return "redirect:/type";
	}
	@RequestMapping("/type/{id}")
	public String delete(@PathVariable String id){
		typeServiceImpl.delete(id);
		return "redirect:/type";
	}

}
