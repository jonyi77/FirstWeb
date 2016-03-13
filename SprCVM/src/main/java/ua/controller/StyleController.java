package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.StyleServiceImpl;

@Controller
public class StyleController {
	
	@Autowired
	private StyleServiceImpl styleServiceImpl;
	
	@RequestMapping("/style")
	public String styleView(Model model){
		model.addAttribute("styles", styleServiceImpl.getAll());
		return "style";
	}
	@RequestMapping(value="/style", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		styleServiceImpl.save(name);
		return "redirect:/style";
	}
	@RequestMapping("/style/{id}")
	public String delete(@PathVariable String id){
		styleServiceImpl.delete(id);
		return "redirect:/style";
	}

}
