package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.impl.ArticleServiceImpl;
import ua.service.impl.BrandServiceImpl;
import ua.service.impl.CategoryServiceImpl;
import ua.service.impl.ColorServiceImpl;
import ua.service.impl.CountryServiceImpl;
import ua.service.impl.SeasonServiceImpl;
import ua.service.impl.SizeServiceImpl;
import ua.service.impl.StyleServiceImpl;
import ua.service.impl.TypeServiceImpl;

@Controller
public class ArticleController {
	@Autowired
	private CountryServiceImpl countryServiceImpl;
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private BrandServiceImpl brandServiceImpl;
	@Autowired
	private ColorServiceImpl colorServiceImpl;
	@Autowired
	private SeasonServiceImpl seasonServiceImpl;
	@Autowired
	private StyleServiceImpl styleServiceImpl;
	@Autowired
	private TypeServiceImpl typeServiceImpl;
	@Autowired
	private SizeServiceImpl sizeServiceImpl;
	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	
	@RequestMapping("/article")
	public String articleView(Model model){
		model.addAttribute("countries", countryServiceImpl.getAll());
		model.addAttribute("categories", categoryServiceImpl.getAll());
		model.addAttribute("brands", brandServiceImpl.getAll());
		model.addAttribute("colors", colorServiceImpl.getAll());
		model.addAttribute("seasons", seasonServiceImpl.getAll());
		model.addAttribute("styles", styleServiceImpl.getAll());
		model.addAttribute("types", typeServiceImpl.getAll());
		model.addAttribute("sizes", sizeServiceImpl.getAll());
		model.addAttribute("articles", articleServiceImpl.getAll());

		return "article";
	}
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public String save(@RequestParam String name, int typeId, int sizeId, double price, int seasonId,
			int categoryId, int countryId, int styleId, int colorId, String top, int brandId){
		articleServiceImpl.save(name, typeServiceImpl.findById(typeId), sizeServiceImpl.findById(sizeId), 
				price, seasonServiceImpl.findById(seasonId), categoryServiceImpl.findById(categoryId), 
				countryServiceImpl.findById(countryId), styleServiceImpl.findById(styleId), colorServiceImpl.findById(colorId), top,
				brandServiceImpl.findById(brandId));
		return "redirect:/article";
	}
	@RequestMapping("/article/{id}")
	public String delete(@PathVariable String id){
		articleServiceImpl.delete(id);
		return "redirect:/article";
	}

}
