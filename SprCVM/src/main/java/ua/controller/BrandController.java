package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.BrandServiceImpl;

@Controller
public class BrandController {
	
	@Autowired
	private BrandServiceImpl brandServiceImpl;
	
	@RequestMapping("/brand")
	public String brandView(Model model){
		model.addAttribute("brands", brandServiceImpl.getAll());
		return "brand";
	}
	@RequestMapping(value="/brand", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		brandServiceImpl.save(name);
		return "redirect:/brand";
	}
	@RequestMapping("/brand/{id}")
	public String delete(@PathVariable String id){
		brandServiceImpl.delete(id);
		return "redirect:/brand";
	}

}
