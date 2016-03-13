package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Season;
import ua.repository.SeasonRepository;
import ua.service.SeasonService;

@Service
public class SeasonServiceImpl implements SeasonService {
	
	@Autowired
	private SeasonRepository seasonRepository;
	
	public void save(String name) {
		Season season = new Season();
		season.setName(name);
		seasonRepository.save(season);
	}

	public void delete(String id) {
		try {
			int idParse = Integer.parseInt(id);
			seasonRepository.delete(idParse);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	public Season getByName(String name) {
		return seasonRepository.findByName(name);
	}

	public Season editSeason(Season season) {
		Season saveSeason = seasonRepository.save(season);
		return saveSeason;
	}

	public Iterable<Season> getAll() {
		return seasonRepository.findAll();
	}

}
