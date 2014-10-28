package org.lalosuarez.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.lalosuarez.app.dto.Tournament;

public class TournamentDaoMongoImpl implements TournamentDao {

	public List<Tournament> findAll() {
		System.out.println("find all in a mongodb");
		List<Tournament> list = new ArrayList<Tournament>();
		return list;
	}

	public void save(Tournament object) {
		// TODO Auto-generated method stub
		
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	public Tournament find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tournament> findByNumberOfResults(int start, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tournament> findByParameter(String searchParameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
