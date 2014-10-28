package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lalosuarez.app.dto.Team;
import org.lalosuarez.app.service.TeamService;
import org.springframework.stereotype.Component;


@Component
@Path("/json/teams")
public class TeamWebServiceImpl implements TeamWebService {
		
	private TeamService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Team> findAll() {

 		List<Team> list = service.findAll();
 		
 		for (Team object :  list) {
 			object.setLeague(null);
 		}
 		
		return list;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Team find(@PathParam("id") int id) {
 		Team object = service.find(id);
 		object.setLeague(null);
		return object;
	}
		
	public TeamService getService() {
		return service;
	}

	public void setService(TeamService service) {
		this.service = service;
	}
}
