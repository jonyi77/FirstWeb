package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
		Category saveCategory = categoryRepository.save(category);
		return saveCategory;
	}

	public void delete(int id) {
		categoryRepository.delete(id);

	}

	public Category getByName(String name) {
		return categoryRepository.findByName(name);
	}

	public Category editCategory(Category category) {
		Category saveCategory = categoryRepository.save(category);
		return saveCategory;
	}

	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}

}
