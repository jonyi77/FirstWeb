package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Article;
import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Country;
import ua.entity.Season;
import ua.entity.Size;
import ua.entity.Style;
import ua.entity.Type;
import ua.repository.ArticleRepository;
import ua.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	public void save(String name, Type type, Size size, double price, Season season,
			Category category, Country country, Style style, Color color, String top, Brand brand) {
		Article article = new Article();
		article.setName(name);
		article.setType(type);
		article.setSize(size);
		article.setPrice(price);
		article.setSeason(season);
		article.setCategory(category);
		article.setCountry(country);
		article.setStyle(style);
		article.setColor(color);
		article.setTop(top);
		article.setBrand(brand);
		articleRepository.save(article);
	}

	public void delete(String id) {
		try {
			int idParse = Integer.parseInt(id);
			articleRepository.delete(idParse);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	public Article getByName(String name) {
		return articleRepository.findByName(name);
	}

	public Article editArticle(Article article) {
		Article savedArticle = articleRepository.save(article);
		return savedArticle;
	}

	public Iterable<Article> getAll() {
		return articleRepository.findAll();
	}
	
	public Article findById(String id){
		int parseId = Integer.parseInt(id);
		return articleRepository.findOne(parseId);
		
	}
	public void addUrlFile(int id, String url){
		Article article = articleRepository.findOne(id);
		article.setImageUrl(url);
		articleRepository.save(article);
	}

}
