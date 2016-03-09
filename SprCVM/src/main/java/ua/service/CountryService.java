package ua.service;

import java.util.List;

import ua.entity.Country;

public interface CountryService {
	
	void save(String name);
	void delete(int id);
	Country getByName(String name);
	Country editCountry(Country country);
	List<Country> getAll();

}
