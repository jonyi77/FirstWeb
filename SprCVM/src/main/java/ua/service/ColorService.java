package ua.service;

import ua.entity.Color;

public interface ColorService {
	
	void save(String name);
	void delete(String id);
	Color getByName(String name);
	Color editColor(Color color);
	Iterable<Color> getAll();
}
