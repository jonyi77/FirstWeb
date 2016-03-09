package ua.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {
	@Query("select c from Country c where c.name = :name")
	Country findByName(@Param("name") String name);
}
