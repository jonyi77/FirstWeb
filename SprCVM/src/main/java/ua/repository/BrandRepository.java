package ua.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Brand;

public interface BrandRepository extends CrudRepository<Brand, Integer>{
	@Query("select b from Brand b where b.name = :name")
	Brand findByName(@Param("name") String name);

}
