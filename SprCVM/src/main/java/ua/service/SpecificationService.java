package ua.service;

import java.util.List;

import ua.entity.Specification;

public interface SpecificationService {
	
	Specification addSpecification(Specification specification);
	void delete(int id);
	Specification editSpecification(Specification specification);
	List<Specification> getAll();

}
