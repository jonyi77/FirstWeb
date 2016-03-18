package ua.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Size;

public interface SizeRepository extends CrudRepository<Size, Integer> {
	@Query("select s from Size s where s.name = :name")
	Size findByName(@Param("name") String name);

}
