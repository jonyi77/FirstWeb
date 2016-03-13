package ua.service;

import ua.entity.Season;

public interface SeasonService {
	
	void save(String name);
	void delete(String id);
	Season getByName (String name);
	Season editSeason(Season season);
	Iterable<Season> getAll();

}
