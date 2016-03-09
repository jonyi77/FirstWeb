package ua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Color;

public interface ColorRepository extends CrudRepository<Color, Integer> {
	
	@Query("select c from Color c where c.name = :name")
	Color findByName(@Param("name")String name);

}
