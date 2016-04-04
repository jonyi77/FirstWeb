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

import ua.entity.Brand;
import ua.entity.User;
import ua.service.binder.BrandEditor;
import ua.service.impl.BrandServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class BrandController {

	@Autowired
	private BrandServiceImpl brandServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandServiceImpl));
	}

	@RequestMapping("/admin/brand")
	public String brandView(Model model, Principal principal) {
		User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);
		model.addAttribute("brands", brandServiceImpl.getAll());
		model.addAttribute("brand", new Brand());
		return "brand";

	}

	// @RequestMapping(value="/brand", method=RequestMethod.POST)
	// public String save(@RequestParam String name){
	// brandServiceImpl.save(name);
	// return "redirect:/brand";
	// }
	@RequestMapping(value = "/admin/brand", method = RequestMethod.POST)
	public String save(@ModelAttribute Brand brand) {
		brandServiceImpl.editBrand(brand);
		return "redirect:/admin/brand";
	}

	@RequestMapping("/admin/brand/{id}")
	public String delete(@PathVariable String id) {
		brandServiceImpl.delete(id);
		return "redirect:/admin/brand";
	}

	@RequestMapping("/admin/brand/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("brand", brandServiceImpl.findById(Integer.parseInt(id)));
		return "brand";
	}

}
