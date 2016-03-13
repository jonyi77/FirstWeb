package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.CategoryServiceImpl;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@RequestMapping("/category")
	public String categoryView(Model model){
		model.addAttribute("categories", categoryServiceImpl.getAll());
		return "category";
	}
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		categoryServiceImpl.save(name);
		return "redirect:/category";
	}
	@RequestMapping("/category/{id}")
	public String delete(@PathVariable String id){
		categoryServiceImpl.delete(id);
		return "redirect:/category";
	}

}
