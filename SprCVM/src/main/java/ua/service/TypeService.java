package ua.service;

import ua.entity.Type;

public interface TypeService {
	
	void save(String name);
	void delete(String id);
	Type getByName(String name);
	Type editName(Type type);
	Iterable<Type> getAll();

}
