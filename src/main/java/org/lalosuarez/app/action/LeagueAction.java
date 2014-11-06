package org.lalosuarez.app.action;

import java.util.List;

import org.lalosuarez.app.dto.League;
import org.lalosuarez.app.service.LeagueService;
import org.lalosuarez.util.paginator.Paginator;

import com.opensymphony.xwork2.ActionSupport;

public class LeagueAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private LeagueService service;
	
	private League league;

	private List<League> leagues;
	
	private Paginator paginator;
	
	private List<Integer> paginationItems;
	
	private int page = 1;
		
	@SuppressWarnings("unchecked")
	public String list() {
		
		List<League> list = service.findAll();
		
		paginator.setNumberOfElementsToShow(5);
		
		setPaginationItems(
				paginator.createPaginationItems(list.size())
		);
				
		setPage(page > paginationItems.size() ? 1 : page);
		
		setLeagues(
			paginator.paginate(list, page)
		);
		
		return SUCCESS;
	}
	
	public String add() {
		setLeague(null);
		setPage(1);
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

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public List<Integer> getPaginationItems() {
		return paginationItems;
	}

	public void setPaginationItems(List<Integer> paginationItems) {
		this.paginationItems = paginationItems;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
