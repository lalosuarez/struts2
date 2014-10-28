package org.lalosuarez.app.action;

import java.util.List;

import org.lalosuarez.app.dto.League;
import org.lalosuarez.app.dto.Team;
import org.lalosuarez.app.service.TeamService;
import org.lalosuarez.app.service.LeagueService;

import com.opensymphony.xwork2.ActionSupport;

public class TeamAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

	private TeamService service;
	
	private LeagueService leagueService;
	
	private Team team;

	private List<Team> teams;
	
	private League league;
	 
	
    public String list() {
    	setTeams(service.findAll());
 
        return SUCCESS;
    }

    public String add() {
        setTeam(null);
        setLeague(null);
        
        return SUCCESS;
    }

    public String save() {
        team.setLeague(leagueService.find(league.getId()));
        service.save(team);
        
        return SUCCESS;
    }

    public String edit() {
        setTeam(service.find(team.getId()));
        setLeague(team.getLeague());
        
        //System.out.println("BELONGS TO " + team.getLeague().getName());
        
        return SUCCESS;
    }

    public String activate() {
        service.remove(team.getId());
        
        return SUCCESS;
    }

    public String getAllJson() {
    	setTeams(service.findAll());

        return SUCCESS;
    }
    
	public TeamService getService() {
		return service;
	}

	public void setService(TeamService service) {
		this.service = service;
	}

	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	} 
}
