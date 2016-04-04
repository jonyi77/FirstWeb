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

import ua.entity.Role;
import ua.entity.Size;
import ua.entity.User;
import ua.service.binder.SizeEditor;
import ua.service.impl.SizeServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class SizeController {

	@Autowired
	private SizeServiceImpl sizeServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeServiceImpl));
	}

	@RequestMapping("/admin/size")
	public String sizeView(Model model, Principal principal) {
		if (principal != null) {
			User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
			if (Role.ROLE_ADMIN == user.getRole()) {
				model.addAttribute("user", user);
				model.addAttribute("sizes", sizeServiceImpl.getAll());
				model.addAttribute("size", new Size());
				return "size";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}
	}

	// @RequestMapping(value="/size", method=RequestMethod.POST)
	// public String save(@RequestParam String name){
	// sizeServiceImpl.save(name);
	// return "redirect:/size";
	// }
	@RequestMapping(value = "/admin/size", method = RequestMethod.POST)
	public String save(@ModelAttribute Size size) {
		sizeServiceImpl.editSize(size);
		return "redirect:/admin/size";
	}

	@RequestMapping("/admin/size/{id}")
	public String delete(@PathVariable String id) {
		sizeServiceImpl.delete(id);
		return "redirect:/admin/size";
	}

	@RequestMapping("/admin/size/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("size", sizeServiceImpl.findById(Integer.parseInt(id)));
		return "size";
	}

}
