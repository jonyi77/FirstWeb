package ua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	@Query("select c from Category c where c.name = :name")
	Category findByName(@Param("name")String name);

}
