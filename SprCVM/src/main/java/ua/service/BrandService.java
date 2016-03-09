package ua.service;

import java.util.List;

import ua.entity.Brand;

public interface BrandService {
	
	Brand addBrand(Brand brand);
	void delete(int id);
	Brand getByName(String name);
	Brand editBrand(Brand brand);
	List<Brand> getAll();

}
