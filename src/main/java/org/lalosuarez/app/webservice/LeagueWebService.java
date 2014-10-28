package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.PathParam;

import org.lalosuarez.app.dto.League;

public interface LeagueWebService {

	public List<League> findAll();
	
	public League find(@PathParam("id") int id);
}
