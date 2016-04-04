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

import ua.entity.Category;
import ua.entity.Role;
import ua.entity.User;
import ua.service.binder.CategoryEditor;
import ua.service.impl.CategoryServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryServiceImpl));
	}

	@RequestMapping("/admin/category")
	public String categoryView(Model model, Principal principal) {
		if (principal != null) {
			User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
			if (Role.ROLE_ADMIN == user.getRole()) {
				model.addAttribute("user", user);
				model.addAttribute("categories", categoryServiceImpl.getAll());
				model.addAttribute("category", new Category());
				return "category";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}
	}

	// @RequestMapping(value="/category", method=RequestMethod.POST)
	// public String save(@RequestParam String name){
	// categoryServiceImpl.save(name);
	// return "redirect:/category";
	// }
	@RequestMapping(value = "/admin/category", method = RequestMethod.POST)
	public String save(@ModelAttribute Category category) {
		categoryServiceImpl.editCategory(category);
		return "redirect:/admin/category";
	}

	@RequestMapping("/admin/category/{id}")
	public String delete(@PathVariable String id) {
		categoryServiceImpl.delete(id);
		return "redirect:/admin/category";
	}

	@RequestMapping("/admin/category/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("category", categoryServiceImpl.findById(Integer.parseInt(id)));
		return "category";
	}

}
