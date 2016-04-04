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
import ua.entity.Type;
import ua.entity.User;
import ua.service.binder.TypeEditor;
import ua.service.impl.TypeServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class TypeController {

	@Autowired
	private TypeServiceImpl typeServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Type.class, new TypeEditor(typeServiceImpl));
	}

	@RequestMapping("/admin/type")
	public String typeView(Model model, Principal principal) {
		if (principal != null) {
			User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
			if (Role.ROLE_ADMIN == user.getRole()) {
				model.addAttribute("user", user);
				model.addAttribute("types", typeServiceImpl.getAll());
				model.addAttribute("type", new Type());
				return "type";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/admin/type", method = RequestMethod.POST)
	public String save(@ModelAttribute Type type) {
		typeServiceImpl.editType(type);
		return "redirect:/admin/type";
	}

	@RequestMapping("/admin/type/{id}")
	public String delete(@PathVariable String id) {
		typeServiceImpl.delete(id);
		return "redirect:/admin/type";
	}

	@RequestMapping("/admin/type/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("type", typeServiceImpl.findById(Integer.parseInt(id)));
		return "type";
	}

}
