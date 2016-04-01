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

import ua.entity.Style;
import ua.service.binder.StyleEditor;
import ua.service.impl.StyleServiceImpl;

@Controller
public class StyleController {
	
	@Autowired
	private StyleServiceImpl styleServiceImpl;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Style.class, new StyleEditor(styleServiceImpl));
	}
	
	@RequestMapping("/style")
	public String styleView(Model model){
		model.addAttribute("styles", styleServiceImpl.getAll());
		model.addAttribute("style", new Style());
		return "style";
	}
	@RequestMapping(value="/style", method=RequestMethod.POST)
	public String save(@ModelAttribute Style style){
		styleServiceImpl.editStyle(style);
		return "redirect:/style";
	}
	@RequestMapping("/style/{id}")
	public String delete(@PathVariable String id){
		styleServiceImpl.delete(id);
		return "redirect:/style";
	}
	@RequestMapping("/style/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("style", styleServiceImpl.findById(Integer.parseInt(id)));
		return "style";
	}

}
