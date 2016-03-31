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
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.entity.Article;
import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Country;
import ua.entity.Season;
import ua.entity.Size;
import ua.entity.Style;
import ua.entity.Type;
import ua.service.binder.BrandEditor;
import ua.service.binder.CategoryEditor;
import ua.service.binder.ColorEditor;
import ua.service.binder.CountryEditor;
import ua.service.binder.SeasonEditor;
import ua.service.binder.SizeEditor;
import ua.service.binder.StyleEditor;
import ua.service.binder.TypeEditor;
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
	
	@InitBinder
	protected void initBinderCountry(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryServiceImpl));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryServiceImpl));
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandServiceImpl));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorServiceImpl));
		binder.registerCustomEditor(Season.class, new SeasonEditor(seasonServiceImpl));
		binder.registerCustomEditor(Style.class, new StyleEditor(styleServiceImpl));
		binder.registerCustomEditor(Type.class, new TypeEditor(typeServiceImpl));
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeServiceImpl));
	}

	
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
		
		model.addAttribute("article", new Article());

		return "article";
	}
	
	@RequestMapping(value = "/article", method = RequestMethod.POST)
	public String save(@ModelAttribute Article article){
		articleServiceImpl.editArticle(article);
		return "redirect:/article";
	}
	
//	@RequestMapping(value="/article", method=RequestMethod.POST)
//	public String save(@RequestParam String name, int typeId, int sizeId, double price, int seasonId,
//			int categoryId, int countryId, int styleId, int colorId, String top, int brandId){
//		articleServiceImpl.save(name, typeServiceImpl.findById(typeId), sizeServiceImpl.findById(sizeId), 
//				price, seasonServiceImpl.findById(seasonId), categoryServiceImpl.findById(categoryId), 
//				countryServiceImpl.findById(countryId), styleServiceImpl.findById(styleId), colorServiceImpl.findById(colorId), top,
//				brandServiceImpl.findById(brandId));
//		return "redirect:/article";
//	}
	
	@RequestMapping("/article/{id}")
	public String delete(@PathVariable String id){
		articleServiceImpl.delete(id);
		return "redirect:/article";
	}

}
