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

import ua.entity.Type;
import ua.service.binder.TypeEditor;
import ua.service.impl.TypeServiceImpl;

@Controller
public class TypeController {
	
	@Autowired
	private TypeServiceImpl typeServiceImpl;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Type.class, new TypeEditor(typeServiceImpl));
	}
	
	@RequestMapping("/type")
	public String typeView(Model model){
		model.addAttribute("types", typeServiceImpl.getAll());
		model.addAttribute("type", new Type());
		return "type";
	}
	@RequestMapping(value="/type", method=RequestMethod.POST)
	public String save(@ModelAttribute Type type){
		typeServiceImpl.editType(type);
		return "redirect:/type";
	}
	@RequestMapping("/type/{id}")
	public String delete(@PathVariable String id){
		typeServiceImpl.delete(id);
		return "redirect:/type";
	}
	@RequestMapping("/type/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("type", typeServiceImpl.findById(Integer.parseInt(id)));
		return "type";
	}

}
