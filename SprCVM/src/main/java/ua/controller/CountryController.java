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

import ua.entity.Country;
import ua.entity.User;
import ua.service.binder.CountryEditor;
import ua.service.impl.CountryServiceImpl;
import ua.service.impl.UserServiceImpl;

@Controller
public class CountryController {

	@Autowired
	private CountryServiceImpl countryServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, new CountryEditor(countryServiceImpl));
	}

	// @RequestMapping("/country")
	// public String show(){
	// System.out.println("З контроллера");
	// return "country";
	// }
	@RequestMapping(value = "/admin/country", method = RequestMethod.POST)
	public String save(@ModelAttribute Country country) {
		// countryServiceImpl.save(name);
		countryServiceImpl.editCountry(country);

		return "redirect:/admin/country";
	}

	@RequestMapping("/admin/country")
	public String countryView(Model model, Principal principal) {
		User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));

		model.addAttribute("user", user);
		model.addAttribute("countries", countryServiceImpl.getAll());
		model.addAttribute("country", new Country());
		return "country";

	}

	@RequestMapping("/admin/country/{id}")
	public String delete(@PathVariable String id) {
		countryServiceImpl.delete(id);
		return "redirect:/admin/country";
	}

	@RequestMapping("/admin/country/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("country", countryServiceImpl.findById(Integer.parseInt(id)));

		return "country";
	}

}
