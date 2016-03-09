package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Color;
import ua.repository.ColorRepository;
import ua.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {
	
	@Autowired
	private ColorRepository colorRepository;

	public Color addColor(Color color) {
		Color saveColor = colorRepository.save(color);
		return saveColor;
	}

	public void delete(int id) {
		colorRepository.delete(id);

	}

	public Color getByName(String name) {
		return colorRepository.findByName(name);
	}

	public Color editColor(Color color) {
		Color saveColor = colorRepository.save(color);
		return saveColor;
	}

	public List<Color> getAll() {
		return (List<Color>) colorRepository.findAll();
	}

}
