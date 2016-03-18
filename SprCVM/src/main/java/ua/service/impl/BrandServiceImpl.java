package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;

	public void save(String name) {
		Brand brand = new Brand();
		brand.setName(name);
		brandRepository.save(brand);

	}

	public void delete(String id) {
		try {
			int idParse = Integer.parseInt(id);
			brandRepository.delete(idParse);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	public Brand getByName(String name) {
		return brandRepository.findByName(name);
	}

	public Brand editBrand(Brand brand) {
		Brand saveBrand = brandRepository.save(brand);
		return saveBrand;
	}

	public Iterable<Brand> getAll() {
		return brandRepository.findAll();
	}

	@Override
	public Brand findById(int id) {
		return brandRepository.findOne(id);
	}

}
