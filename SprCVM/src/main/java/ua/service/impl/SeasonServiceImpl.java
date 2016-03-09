package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Season;
import ua.repository.SeasonRepository;
import ua.service.SeasonService;

@Service
public class SeasonServiceImpl implements SeasonService {
	
	@Autowired
	private SeasonRepository seasonRepository;
	
	public Season addSeason(Season season) {
		Season saveSeason = seasonRepository.save(season);
		return saveSeason;
	}

	public void delete(int id) {
		seasonRepository.delete(id);

	}

	public Season getByName(String name) {
		return seasonRepository.findByName(name);
	}

	public Season editSeason(Season season) {
		Season saveSeason = seasonRepository.save(season);
		return saveSeason;
	}

	public List<Season> getAll() {
		return (List<Season>) seasonRepository.findAll();
	}

}
