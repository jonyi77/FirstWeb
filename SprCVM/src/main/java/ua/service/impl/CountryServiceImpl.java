package ua.service.impl;

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

	public void delete(String id) {
		try {
			int parsI = Integer.parseInt(id);
			countryRepository.delete(parsI);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		
	}

	public Country getByName(String name) {
		return countryRepository.findByName(name);
	}

	public Country editCountry(Country country) {
		Country savedCountry = countryRepository.save(country);
		return savedCountry;
	}

	public Iterable<Country> getAll() {
		return countryRepository.findAll();
	}
	public Country findById(int id){
		return countryRepository.findOne(id);
	}
	

}
