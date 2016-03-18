package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Color;
import ua.repository.ColorRepository;
import ua.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {
	
	@Autowired
	private ColorRepository colorRepository;

	public void save(String name) {
		Color color = new Color();
		color.setName(name);
		colorRepository.save(color);

	}

	public void delete(String id) {
		try {
			int parsI = Integer.parseInt(id);
			colorRepository.delete(parsI);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

	}

	public Color getByName(String name) {
		return colorRepository.findByName(name);
	}

	public Color editColor(Color color) {
		Color saveColor = colorRepository.save(color);
		return saveColor;
	}

	public Iterable<Color> getAll() {
		return colorRepository.findAll();
	}
	public Color findById(int id){
		return colorRepository.findOne(id);
	}

}
