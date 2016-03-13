package ua.service;

import ua.entity.Brand;

public interface BrandService {
	
	void save(String name);
	void delete(String id);
	Brand getByName(String name);
	Brand editBrand(Brand brand);
	Iterable<Brand> getAll();

}
