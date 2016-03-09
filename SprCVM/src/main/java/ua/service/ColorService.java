package ua.service;

import java.util.List;

import ua.entity.Color;

public interface ColorService {
	
	Color addColor(Color color);
	void delete(int id);
	Color getByName(String name);
	Color editColor(Color color);
	List<Color> getAll();
}
