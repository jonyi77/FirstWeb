package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Category;
import ua.service.binder.CategoryEditor;
import ua.service.impl.CategoryServiceImpl;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryServiceImpl));
	}
	
	@RequestMapping("/category")
	public String categoryView(Model model){
		model.addAttribute("categories", categoryServiceImpl.getAll());
		model.addAttribute("category", new Category());
		return "category";
	}
//	@RequestMapping(value="/category", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		categoryServiceImpl.save(name);
//		return "redirect:/category";
//	}
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String save(@ModelAttribute Category category){
		categoryServiceImpl.editCategory(category);
		return "redirect:/category";
	}
	@RequestMapping("/category/{id}")
	public String delete(@PathVariable String id){
		categoryServiceImpl.delete(id);
		return "redirect:/category";
	}
	@RequestMapping("/category/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("category", categoryServiceImpl.findById(Integer.parseInt(id)));
		return "category";
	}

}
