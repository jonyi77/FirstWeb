package ua.service;

import ua.entity.Style;

public interface StyleService {
	
	void save(String name);
	void delete(String id);
	Style getByName(String name);
	Style editStyle(Style style);
	Iterable<Style> getAll();

}
