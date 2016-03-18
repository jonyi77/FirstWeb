package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.SizeServiceImpl;

@Controller
public class SizeController {
	
	@Autowired
	private SizeServiceImpl sizeServiceImpl;
	
	@RequestMapping("/size")
	public String sizeView(Model model){
		model.addAttribute("sizes", sizeServiceImpl.getAll());
		return "size";
	}
	@RequestMapping(value="/size", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		sizeServiceImpl.save(name);
		return "redirect:/size";
	}
	@RequestMapping("/size/{id}")
	public String delete(@PathVariable String id){
		sizeServiceImpl.delete(id);
		return "redirect:/size";
	}

}
