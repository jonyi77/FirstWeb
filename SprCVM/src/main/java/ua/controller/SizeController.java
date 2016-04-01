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

import ua.entity.Size;
import ua.service.binder.SizeEditor;
import ua.service.impl.SizeServiceImpl;

@Controller
public class SizeController {
	
	@Autowired
	private SizeServiceImpl sizeServiceImpl;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeServiceImpl));
	}
	
	@RequestMapping("/size")
	public String sizeView(Model model){
		model.addAttribute("sizes", sizeServiceImpl.getAll());
		model.addAttribute("size", new Size());
		return "size";
	}
//	@RequestMapping(value="/size", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		sizeServiceImpl.save(name);
//		return "redirect:/size";
//	}
	@RequestMapping(value="/size", method=RequestMethod.POST)
	public String save(@ModelAttribute Size size){
		sizeServiceImpl.editSize(size);
		return "redirect:/size";
	}
	@RequestMapping("/size/{id}")
	public String delete(@PathVariable String id){
		sizeServiceImpl.delete(id);
		return "redirect:/size";
	}
	@RequestMapping("/size/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("size", sizeServiceImpl.findById(Integer.parseInt(id)));
		return "size";
	}

}
