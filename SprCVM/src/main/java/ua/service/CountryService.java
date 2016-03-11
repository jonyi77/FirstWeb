package ua.service;

import ua.entity.Country;

public interface CountryService {
	
	void save(String name);
	void delete(String id);
	Country getByName(String name);
	Country editCountry(Country country);
	Iterable<Country> getAll();

}
