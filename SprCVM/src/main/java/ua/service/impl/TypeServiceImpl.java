package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Type;
import ua.repository.TypeRepository;
import ua.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeRepository typeRepository;

	public void save(String name) {
		Type type = new Type();
		type.setName(name);
		typeRepository.save(type);
	}

	public void delete(String id) {
		try {
			int idParse = Integer.parseInt(id);
			typeRepository.delete(idParse);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	public Type getByName(String name) {
		return typeRepository.findByName(name);
	}

	public Type editName(Type type) {
		Type saveType = typeRepository.save(type);
		return saveType;
	}

	public Iterable<Type> getAll() {
		return typeRepository.findAll();
	}

}
