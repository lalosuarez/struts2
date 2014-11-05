package org.lalosuarez.app.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.ws.rs.PathParam;

import org.lalosuarez.app.dto.League;

@WebService(
	name="LeagueService",
	targetNamespace="http://www.webservice.soccer.lalosuarez.org"
)
@SOAPBinding(style=Style.DOCUMENT)
public interface LeagueWebService {
	
	@WebMethod(action="find-leagues", operationName="findLeagues")
	@WebResult(name="League")	
	public List<League> findLeagues();

	@WebMethod(action="find-league", operationName="findLeague")
	@WebResult(name="League")
	public League findLeague(@PathParam("id") int id);
}
