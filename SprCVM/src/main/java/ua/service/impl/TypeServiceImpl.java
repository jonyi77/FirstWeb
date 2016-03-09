package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Type;
import ua.repository.TypeRepository;
import ua.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeRepository typeRepository;

	public Type addType(Type type) {
		Type saveType = typeRepository.save(type);
		return saveType;
	}

	public void delete(int id) {
		typeRepository.delete(id);
	}

	public Type getByName(String name) {
		return typeRepository.findByName(name);
	}

	public Type editName(Type type) {
		Type saveType = typeRepository.save(type);
		return saveType;
	}

	public List<Type> getAll() {
		return (List<Type>) typeRepository.findAll();
	}

}
