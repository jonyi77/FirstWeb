package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.CountryServiceImpl;

@Controller
public class CountryController {
	@Autowired
	private CountryServiceImpl countryServiceImpl;
	
	@RequestMapping("/country")
	public String show(){
		System.out.println("З контроллера");
		return "country";
	}
	@RequestMapping(value = "/country", method = RequestMethod.POST)
	public String save(@RequestParam String name){
		countryServiceImpl.save(name);
		
		return "redirect:/country";
	}
	

}
