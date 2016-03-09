package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Article;
import ua.repository.ArticleRepository;
import ua.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	public Article addArticle(Article article) {
		Article savedArticle = articleRepository.save(article);
		return savedArticle;
	}

	public void delete(int id) {
		articleRepository.delete(id);

	}

	public Article getByName(String name) {
		return articleRepository.findByName(name);
	}

	public Article editArticle(Article article) {
		Article savedArticle = articleRepository.save(article);
		return savedArticle;
	}

	public List<Article> getAll() {
		return (List<Article>) articleRepository.findAll();
	}

}
