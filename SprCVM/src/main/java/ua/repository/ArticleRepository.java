package ua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer>{
	
	@Query("select a from Article a where a.name = :name")
	Article findByName(@Param("name") String name);

}
