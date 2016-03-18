package ua.service;

import ua.entity.Article;
import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Country;
import ua.entity.Season;
import ua.entity.Size;
import ua.entity.Style;
import ua.entity.Type;

public interface ArticleService {
	
	void save(String name, Type type, Size size, double price, Season season,
			Category category, Country country, Style style, Color color, String top, Brand brand);
	void delete(String id);
	Article getByName(String name);
	Article editArticle(Article article);
	Iterable<Article> getAll();

}
