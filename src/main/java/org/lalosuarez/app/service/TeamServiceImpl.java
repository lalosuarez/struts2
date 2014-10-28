package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dao.TeamDao;
import org.lalosuarez.app.dto.Team;

public class TeamServiceImpl implements TeamService {

	private TeamDao dao;

	public List<Team> findAll() {
		return dao.findAll();
	}

	public void save(Team object) {
		dao.save(object);
	}

	public void remove(int id) {
		dao.remove(id);
	}

	public Team find(int id) {
		return dao.find(id);
	}

	public TeamDao getDao() {
		return dao;
	}

	public void setDao(TeamDao dao) {
		this.dao = dao;
	}
}
