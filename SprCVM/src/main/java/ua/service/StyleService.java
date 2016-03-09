package ua.service;

import java.util.List;

import ua.entity.Style;

public interface StyleService {
	
	Style addStyle(Style style);
	void delete(int id);
	Style getByName(String name);
	Style editStyle(Style style);
	List<Style> getAll();

}
