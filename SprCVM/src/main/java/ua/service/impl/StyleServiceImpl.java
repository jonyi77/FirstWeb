package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Style;
import ua.repository.StyleRepository;
import ua.service.StyleService;

@Service
public class StyleServiceImpl implements StyleService {
	
	@Autowired
	private StyleRepository styleRepository;

	public Style addStyle(Style style) {
		Style saveStyle = styleRepository.save(style);
		return saveStyle;
	}

	public void delete(int id) {
		styleRepository.delete(id);
	}

	public Style getByName(String name) {
		return styleRepository.findByName(name);
	}

	public Style editStyle(Style style) {
		Style saveStyle = styleRepository.save(style);
		return saveStyle;
	}

	public List<Style> getAll() {
		return (List<Style>) styleRepository.findAll();
	}

}
