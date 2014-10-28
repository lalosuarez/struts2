package org.lalosuarez.app.action;

import java.util.List;

import org.lalosuarez.app.dto.League;
import org.lalosuarez.app.service.LeagueService;

import com.opensymphony.xwork2.ActionSupport;

public class LeagueAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private LeagueService service;
	
	private League league;

	private List<League> leagues;
		
	public String list() {
		setLeagues(service.findAll());
		return SUCCESS;
	}

	public String add() {
		setLeague(null);
		return SUCCESS;
	}

	public String save() {
		service.save(league);
		return SUCCESS;
	}

	public String edit() {
		setLeague(service.find(league.getId()));		
		return SUCCESS;
	}

	public String activate() {
		service.remove(league.getId());
		return SUCCESS;
	}	

	public String getAllJson() {

		List<League> list = service.findAll();
	
		setLeagues(list);
				
		return SUCCESS;
	}

	public LeagueService getService() {
		return service;
	}

	public void setService(LeagueService service) {
		this.service = service;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}	
}
