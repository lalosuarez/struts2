package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dao.TournamentDao;
import org.lalosuarez.app.dto.Tournament;

public class TournamentServiceImpl implements TournamentService {

	private TournamentDao dao;
	
	public List<Tournament> findAll() {
		return dao.findAll();
	}

	public void save(Tournament object) {
		dao.save(object);
	}

	public void remove(int id) {
		dao.remove(id);
	}

	public Tournament find(int id) {
		return dao.find(id);
	}

	public List<Tournament> findByNumberOfResults(int start, int max) {
		return dao.findByNumberOfResults(start, max);
	}

	public List<Tournament> findByParameter(String searchParameter) {
		return dao.findByParameter(searchParameter);
	}

	public TournamentDao getDao() {
		return dao;
	}

	public void setDao(TournamentDao dao) {
		this.dao = dao;
	}
}
