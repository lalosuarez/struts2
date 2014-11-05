package org.lalosuarez.app.webservice;

import java.util.List;

import javax.jws.WebService;

import org.lalosuarez.app.dto.League;
import org.lalosuarez.app.service.LeagueService;

@WebService(
	endpointInterface="org.lalosuarez.app.webservice.LeagueWebService",	
	portName="LeagueServicePort",
	serviceName="LeagueWebService"
)
public class LeagueSoapWebServiceImpl implements LeagueWebService {

	private LeagueService service;
	
	@Override
	public List<League> findLeagues() {
		
 		List<League> list = service.findAll();
 		
 		if (!list.isEmpty()) {
 	 		for (League object :  list) {
 	 			object.setTournaments(null);
 	 		} 			
 		}
 		
		return list;
	}

	@Override
	public League findLeague(int id) {
		
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
