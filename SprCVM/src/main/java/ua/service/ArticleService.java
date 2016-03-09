package ua.service;

import java.util.List;

import ua.entity.Article;

public interface ArticleService {
	
	Article addArticle(Article article);
	void delete(int id);
	Article getByName(String name);
	Article editArticle(Article article);
	List<Article> getAll();

}
