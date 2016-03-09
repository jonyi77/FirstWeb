package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;

	public Brand addBrand(Brand brand) {
		Brand saveBrand = brandRepository.save(brand);
		return saveBrand;
	}

	public void delete(int id) {
		brandRepository.delete(id);
	}

	public Brand getByName(String name) {
		return brandRepository.findByName(name);
	}

	public Brand editBrand(Brand brand) {
		Brand saveBrand = brandRepository.save(brand);
		return saveBrand;
	}

	public List<Brand> getAll() {
		return (List<Brand>) brandRepository.findAll();
	}

}
