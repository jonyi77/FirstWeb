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

import ua.entity.Season;
import ua.service.binder.SeasonEditor;
import ua.service.impl.SeasonServiceImpl;

@Controller
public class SeasonController {
	
	@Autowired
	private SeasonServiceImpl seasonServiceImpl;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Season.class, new SeasonEditor(seasonServiceImpl));
	}
	
	@RequestMapping("/season")
	public String seasonView(Model model){
		model.addAttribute("seasons", seasonServiceImpl.getAll());
		model.addAttribute("season", new Season());
		return "season";
	}
	
//	@RequestMapping(value="/season", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		seasonServiceImpl.save(name);
//		return "redirect:/season";
//	}
	
	@RequestMapping(value="/season", method=RequestMethod.POST)
	public String save(@ModelAttribute Season season){
		seasonServiceImpl.editSeason(season);
		return "redirect:/season";
	}
	@RequestMapping("/season/{id}")
	public String delete(@PathVariable String id){
		seasonServiceImpl.delete(id);
		return "redirect:/season";
	}
	
	@RequestMapping("/season/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("season", seasonServiceImpl.findById(Integer.parseInt(id)));
		return "season";
	}

}
