package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Specification;
import ua.repository.SpecificationRepository;
import ua.service.SpecificationService;

@Service
public class SpecificationServiceImpl implements SpecificationService {
	
	@Autowired
	private SpecificationRepository specificationRepository;

	public Specification addSpecification(Specification specification) {
		Specification saveSpecification = specificationRepository.save(specification);
		return saveSpecification;
	}

	public void delete(int id) {
		specificationRepository.delete(id);

	}

	public Specification editSpecification(Specification specification) {
		Specification saveSpecification = specificationRepository.save(specification);
		return saveSpecification;
	}

	public List<Specification> getAll() {
		return (List<Specification>) specificationRepository.findAll();
	}

}
