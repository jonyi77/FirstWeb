package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Style;
import ua.repository.StyleRepository;
import ua.service.StyleService;

@Service
public class StyleServiceImpl implements StyleService {
	
	@Autowired
	private StyleRepository styleRepository;

	public void save(String name) {
		Style style = new Style();
		style.setName(name);
		styleRepository.save(style);
	}

	public void delete(String id) {
		try {
			int idParse = Integer.parseInt(id);
			styleRepository.delete(idParse);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	public Style getByName(String name) {
		return styleRepository.findByName(name);
	}

	public Style editStyle(Style style) {
		Style saveStyle = styleRepository.save(style);
		return saveStyle;
	}

	public Iterable<Style> getAll() {
		return styleRepository.findAll();
	}

}
