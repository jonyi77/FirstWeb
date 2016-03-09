package ua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Type;

public interface TypeRepository extends CrudRepository<Type, Integer> {
	
	@Query("select t from Type t where t.name = :name")
	Type findByName(@Param("name") String name);

}
