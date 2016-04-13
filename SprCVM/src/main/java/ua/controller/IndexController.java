package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.impl.ArticleServiceImpl;

@Controller
public class IndexController {
	@Autowired
	private ArticleServiceImpl articleServiceImpl;


	@RequestMapping("/")
	public String indexView(Model model) {
		model.addAttribute("articles", articleServiceImpl.getAll());

		return "index";
	}

	
}
