package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public void save(String name) {
		Category category = new Category();
		category.setName(name);
		categoryRepository.save(category);
	}

	public void delete(String id) {
		try {
			int idParce = Integer.parseInt(id);
			categoryRepository.delete(idParce);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	public Category getByName(String name) {
		return categoryRepository.findByName(name);
	}

	public Category editCategory(Category category) {
		Category saveCategory = categoryRepository.save(category);
		return saveCategory;
	}

	public Iterable<Category> getAll() {
		return categoryRepository.findAll();
	}

}
