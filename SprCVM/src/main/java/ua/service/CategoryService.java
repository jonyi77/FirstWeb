package ua.service;

import java.util.List;

import ua.entity.Category;

public interface CategoryService {
	
	Category addCategory(Category category);
	void delete(int id);
	Category getByName(String name);
	Category editCategory(Category category);
	List<Category> getAll();

}
