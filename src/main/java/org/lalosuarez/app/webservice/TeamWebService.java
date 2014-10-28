package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.PathParam;

import org.lalosuarez.app.dto.Team;

public interface TeamWebService {

	public List<Team> findAll();
	
	public Team find(@PathParam("id") int id);
}
