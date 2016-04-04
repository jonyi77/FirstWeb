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

import ua.entity.Color;
import ua.entity.User;
import ua.service.binder.ColorEditor;
import ua.service.impl.ColorServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class ColorController {

	@Autowired
	private ColorServiceImpl colorServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Color.class, new ColorEditor(colorServiceImpl));
	}

	@RequestMapping("/admin/color")
	public String colorView(Model model, Principal principal) {
		User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));

		model.addAttribute("user", user);
		model.addAttribute("colors", colorServiceImpl.getAll());
		model.addAttribute("color", new Color());
		return "color";

	}

	// @RequestMapping(value="/color", method=RequestMethod.POST)
	// public String save(@RequestParam String name){
	// colorServiceImpl.save(name);
	// return "redirect:/color";
	// }
	@RequestMapping(value = "/admin/color", method = RequestMethod.POST)
	public String save(@ModelAttribute Color color) {
		colorServiceImpl.editColor(color);
		return "redirect:/admin/color";
	}

	@RequestMapping("/admin/color/{id}")
	public String delete(@PathVariable String id) {
		colorServiceImpl.delete(id);
		return "redirect:/admin/color";
	}

	@RequestMapping("/admin/color/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("color", colorServiceImpl.findById(Integer.parseInt(id)));
		return "color";
	}

}
