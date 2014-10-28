package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dao.LeagueDao;
import org.lalosuarez.app.dto.League;

public class LeagueServiceImpl implements LeagueService {
	
	private LeagueDao dao;
	
	public List<League> findAll() {
		return dao.findAll();		
	}

	public void save(League object) {
		dao.save(object);
	}

	public void remove(int id) {
		dao.remove(id);
	}

	public League find(int id) {
		return dao.find(id);
	}

	public LeagueDao getDao() {
		return dao;
	}

	public void setDao(LeagueDao dao) {
		this.dao = dao;
	}
}
