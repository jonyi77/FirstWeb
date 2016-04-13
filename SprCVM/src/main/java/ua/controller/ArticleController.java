package ua.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.entity.Article;
import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Country;
import ua.entity.Season;
import ua.entity.Size;
import ua.entity.Style;
import ua.entity.Type;
import ua.entity.User;
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
import ua.service.impl.UserServiceImpl;

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
	@Autowired
	private UserServiceImpl userServiceImpl;


	@InitBinder
	protected void initBinderCountry(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, new CountryEditor(countryServiceImpl));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryServiceImpl));
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandServiceImpl));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorServiceImpl));
		binder.registerCustomEditor(Season.class, new SeasonEditor(seasonServiceImpl));
		binder.registerCustomEditor(Style.class, new StyleEditor(styleServiceImpl));
		binder.registerCustomEditor(Type.class, new TypeEditor(typeServiceImpl));
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeServiceImpl));
	}

	@RequestMapping("/admin/article")
	public String articleView(Model model, Principal principal) {
		User user = userServiceImpl.findById(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);

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

	@RequestMapping(value = "/admin/article", method = RequestMethod.POST)
	public String save(@ModelAttribute Article article, HttpServletRequest request,
			@RequestParam(value = "image") MultipartFile image) {
		System.out.println(System.getProperty("catalina.home"));
		articleServiceImpl.editArticle(article);
		if (!image.isEmpty()) {
			String uploadRootPath = request.getServletContext().getRealPath("resources");
			File uploadRootDir = new File(uploadRootPath + File.separator + article.getId());
			String uploadPath = uploadRootDir + "\\" + image.getOriginalFilename();
			System.out.println(uploadRootDir);
			if (!uploadRootDir.exists()) {
				uploadRootDir.mkdirs();
			}
			articleServiceImpl.addUrlFile(article.getId(),
					"resources" + "/" + article.getId() + "/" + image.getOriginalFilename());

			saveImage(uploadPath, image);
		}

		// String uploadRootPath = request.getServletContext().getRealPath(
		// "resources");
		// System.out.println("uploadRootPath=" + uploadRootPath);
		// File uploadRootDir = new File(uploadRootPath +File.separator +
		// article.getId());
		// System.out.println(uploadRootDir);
		//
		// if (!uploadRootDir.exists()) {
		// uploadRootDir.mkdirs();
		// }
		// String fileName = null;
		// if (!file.isEmpty()) {
		// try {
		// fileName = file.getOriginalFilename();
		// byte[] bytes = file.getBytes();
		// BufferedOutputStream buffStream =
		// new BufferedOutputStream(new FileOutputStream(new
		// File(uploadRootDir+"/" + fileName)));
		// buffStream.write(bytes);
		// buffStream.close();
		//
		// String tmpUrl ="resources"+"/"+article.getId()+"/" + fileName;
		// System.out.println(tmpUrl);
		// return "redirect:/admin/article";
		// } catch (Exception e){
		// e.printStackTrace();
		// }
		// }

		// fileWriterService.writeFile("", "8", file);

		return "redirect:/admin/article";
	}

	// @RequestMapping(value="/article", method=RequestMethod.POST)
	// public String save(@RequestParam String name, int typeId, int sizeId,
	// double price, int seasonId,
	// int categoryId, int countryId, int styleId, int colorId, String top, int
	// brandId){
	// articleServiceImpl.save(name, typeServiceImpl.findById(typeId),
	// sizeServiceImpl.findById(sizeId),
	// price, seasonServiceImpl.findById(seasonId),
	// categoryServiceImpl.findById(categoryId),
	// countryServiceImpl.findById(countryId),
	// styleServiceImpl.findById(styleId), colorServiceImpl.findById(colorId),
	// top,
	// brandServiceImpl.findById(brandId));
	// return "redirect:/article";
	// }

	@RequestMapping("/admin/article/{id}")
	public String delete(@PathVariable String id, HttpServletRequest request) {
		articleServiceImpl.delete(id);
		File rootDir = new File(
				request.getServletContext().getRealPath("resources") + File.separator + id + File.separator);
		System.out.println(rootDir);
		if (rootDir.exists()) {
			try {
				FileUtils.cleanDirectory(rootDir);
				rootDir.delete();
				System.out.println("delete dir");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "redirect:/admin/article";
	}

	@RequestMapping("/admin/article/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("article", articleServiceImpl.findById(id));
		model.addAttribute("countries", countryServiceImpl.getAll());
		model.addAttribute("categories", categoryServiceImpl.getAll());
		model.addAttribute("brands", brandServiceImpl.getAll());
		model.addAttribute("colors", colorServiceImpl.getAll());
		model.addAttribute("seasons", seasonServiceImpl.getAll());
		model.addAttribute("styles", styleServiceImpl.getAll());
		model.addAttribute("types", typeServiceImpl.getAll());
		model.addAttribute("sizes", sizeServiceImpl.getAll());

		return "article";
	}

	private void saveImage(String filename, MultipartFile image) {
		System.out.println("запис файла");
		try {
			byte[] bytes = image.getBytes();
			System.out.println(filename);
			BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(filename)));
			buffStream.write(bytes);
			buffStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
