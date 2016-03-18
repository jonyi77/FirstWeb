package ua.service;

import ua.entity.Size;

public interface SizeService {
	
	void save(String name);
	void delete(String id);
	Size getByName(String name);
	Size editSize(Size size);
	Iterable<Size> getAll();
	Size findById(int id);

}
