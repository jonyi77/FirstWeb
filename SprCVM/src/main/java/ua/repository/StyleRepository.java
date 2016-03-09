package ua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Style;

public interface StyleRepository extends CrudRepository<Style, Integer> {
	
	@Query("select s from Style s where s.name = :name")
	Style findByName(@Param("name") String name);

}
