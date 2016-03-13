package ua.service;

import ua.entity.Category;

public interface CategoryService {
	
	void save(String name);
	void delete(String id);
	Category getByName(String name);
	Category editCategory(Category category);
	Iterable<Category> getAll();

}
