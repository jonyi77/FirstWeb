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

import ua.entity.Color;
import ua.service.binder.ColorEditor;
import ua.service.impl.ColorServiceImpl;

@Controller
public class ColorController {
	
	@Autowired
	private ColorServiceImpl colorServiceImpl;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Color.class, new ColorEditor(colorServiceImpl));
	}
	
	@RequestMapping("/color")
	public String colorView(Model model){
		model.addAttribute("colors", colorServiceImpl.getAll());
		model.addAttribute("color", new Color());
		return "color";
	}
	
//	@RequestMapping(value="/color", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		colorServiceImpl.save(name);
//		return "redirect:/color";
//	}
	@RequestMapping(value="/color", method=RequestMethod.POST)
	public String save(@ModelAttribute Color color){
		colorServiceImpl.editColor(color);
		return "redirect:/color";
	}
	
	@RequestMapping("/color/{id}")
	public String delete(@PathVariable String id){
		colorServiceImpl.delete(id);
		return "redirect:/color";
	}
	
	@RequestMapping("/color/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("color", colorServiceImpl.findById(Integer.parseInt(id)));
		return "color";
	}

}
