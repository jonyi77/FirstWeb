package ua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Season;

public interface SeasonRepository extends CrudRepository<Season, Integer> {
	
	@Query("select s from Season s where s.name = :name")
	Season findByName(@Param("name") String name);

}
