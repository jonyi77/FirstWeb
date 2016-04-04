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
import ua.entity.Style;
import ua.entity.User;
import ua.service.binder.StyleEditor;
import ua.service.impl.StyleServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class StyleController {

	@Autowired
	private StyleServiceImpl styleServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Style.class, new StyleEditor(styleServiceImpl));
	}

	@RequestMapping("/admin/style")
	public String styleView(Model model, Principal principal) {
		if (principal != null) {
			User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
			if (Role.ROLE_ADMIN == user.getRole()) {
				model.addAttribute("user", user);
				model.addAttribute("styles", styleServiceImpl.getAll());
				model.addAttribute("style", new Style());
				return "style";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/admin/style", method = RequestMethod.POST)
	public String save(@ModelAttribute Style style) {
		styleServiceImpl.editStyle(style);
		return "redirect:/admin/style";
	}

	@RequestMapping("/admin/style/{id}")
	public String delete(@PathVariable String id) {
		styleServiceImpl.delete(id);
		return "redirect:/admin/style";
	}

	@RequestMapping("/admin/style/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("style", styleServiceImpl.findById(Integer.parseInt(id)));
		return "style";
	}

}
