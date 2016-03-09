package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryRepository;

	public void save(String name) {
		Country country = new Country(name);
		countryRepository.save(country);
	}

	public void delete(int id) {
		countryRepository.delete(id);
		
	}

	public Country getByName(String name) {
		return countryRepository.findByName(name);
	}

	public Country editCountry(Country country) {
		Country savedCountry = countryRepository.save(country);
		return savedCountry;
	}

	public List<Country> getAll() {
		return (List<Country>) countryRepository.findAll();
	}
	
	

}
