package org.lalosuarez.app.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.ws.rs.PathParam;

import org.lalosuarez.app.dto.Team;

@WebService(
	name="TeamService",
	targetNamespace="http://www.webservice.soccer.lalosuarez.org"
)
@SOAPBinding(style=Style.DOCUMENT)
public interface TeamWebService {

	@WebMethod(action="find-teams", operationName="findTeams")
	@WebResult(name="Team")	
	public List<Team> findTeams();
	
	@WebMethod(action="find-team", operationName="findTeam")
	@WebResult(name="Team")
	public Team findTeam(@PathParam("id") int id);
}
