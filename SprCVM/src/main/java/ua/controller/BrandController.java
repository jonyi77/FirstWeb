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

import ua.entity.Brand;
import ua.service.binder.BrandEditor;
import ua.service.impl.BrandServiceImpl;

@Controller
public class BrandController {
	
	@Autowired
	private BrandServiceImpl brandServiceImpl;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandServiceImpl));
	}
	
	@RequestMapping("/brand")
	public String brandView(Model model){
		model.addAttribute("brands", brandServiceImpl.getAll());
		model.addAttribute("brand", new Brand());
		return "brand";
	}
//	@RequestMapping(value="/brand", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		brandServiceImpl.save(name);
//		return "redirect:/brand";
//	}
	@RequestMapping(value="/brand", method=RequestMethod.POST)
	public String save(@ModelAttribute Brand brand){
		brandServiceImpl.editBrand(brand);
		return "redirect:/brand";
	}
	@RequestMapping("/brand/{id}")
	public String delete(@PathVariable String id){
		brandServiceImpl.delete(id);
		return "redirect:/brand";
	}
	@RequestMapping("/brand/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("brand", brandServiceImpl.findById(Integer.parseInt(id)));
		return "brand";
	}
	

}
