package org.lalosuarez.app.webservice;

import java.util.List;

import javax.jws.WebService;

import org.lalosuarez.app.dto.Team;
import org.lalosuarez.app.service.TeamService;

@WebService(
	endpointInterface="org.lalosuarez.app.webservice.TeamWebService",
	portName="TeamServicePort",
	serviceName="TeamWebService"
)
public class TeamSoapWebServiceImpl implements TeamWebService {
	
	private TeamService service;

	@Override	
	public List<Team> findTeams() {
 		List<Team> list = service.findAll();
 		
 		if (!list.isEmpty()) {
 	 		for (Team object :  list) {
 	 			object.setLeague(null);
 	 		} 			
 		}
 		
		return list;
	}

	@Override		
	public Team findTeam(int id) {
		Team object = service.find(id);
		
		if (object != null) {
			object.setLeague(null);
		}
 	
		return object;
	}

	public TeamService getService() {
		return service;
	}

	public void setService(TeamService service) {
		this.service = service;
	}

}
