package ua.service;

import ua.entity.Type;

public interface TypeService {
	
	void save(String name);
	void delete(String id);
	Type getByName(String name);
	Type editType(Type type);
	Iterable<Type> getAll();

}
