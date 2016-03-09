package ua.service;

import java.util.List;

import ua.entity.Type;

public interface TypeService {
	
	Type addType(Type type);
	void delete(int id);
	Type getByName(String name);
	Type editName(Type type);
	List<Type> getAll();

}
