package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Size;
import ua.repository.SizeRepository;
import ua.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {
	
	@Autowired
	private SizeRepository sizeRepository;

	@Override
	public void save(String name) {
		Size size = new Size();
		size.setName(name);
		sizeRepository.save(size);
	}

	@Override
	public void delete(String id) {
		try {
			int idParce = Integer.parseInt(id);
			sizeRepository.delete(idParce);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

	}

	@Override
	public Size getByName(String name) {
		return sizeRepository.findByName(name);
	}

	@Override
	public Size editSize(Size size) {
		Size savedSize = sizeRepository.save(size);
		return savedSize;
	}

	@Override
	public Iterable<Size> getAll() {
		return sizeRepository.findAll();
	}

	@Override
	public Size findById(int id) {
		return sizeRepository.findOne(id);
	}

}
