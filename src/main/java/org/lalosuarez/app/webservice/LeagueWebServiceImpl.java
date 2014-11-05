package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lalosuarez.app.dto.League;
import org.lalosuarez.app.service.LeagueService;
import org.springframework.stereotype.Component;

@Component
@Path("/json/leagues")
public class LeagueWebServiceImpl implements LeagueWebService {
	
	private LeagueService service;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<League> findLeagues() {

 		List<League> list = service.findAll();
 		
 		if (!list.isEmpty()) {
 	 		for (League object :  list) {
 	 			object.setTournaments(null);
 	 		} 			
 		}
 		
		return list;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public League findLeague(@PathParam("id") int id) {
				
		League object = service.find(id);
		
		if (object != null) {
			object.setTournaments(null);
		}
 	
		return object;
	}

	public LeagueService getService() {
		return service;
	}

	public void setService(LeagueService service) {
		this.service = service;
	}
}
