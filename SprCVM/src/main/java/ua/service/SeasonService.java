package ua.service;

import java.util.List;

import ua.entity.Season;

public interface SeasonService {
	
	Season addSeason(Season season);
	void delete(int id);
	Season getByName (String name);
	Season editSeason(Season season);
	List<Season> getAll();

}
