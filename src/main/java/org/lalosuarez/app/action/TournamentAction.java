package org.lalosuarez.app.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lalosuarez.app.dto.League;
import org.lalosuarez.app.dto.Tournament;
import org.lalosuarez.app.service.LeagueService;
import org.lalosuarez.app.service.TournamentService;
import org.lalosuarez.util.paginator.Paginator;

import com.opensymphony.xwork2.ActionSupport;

public class TournamentAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private TournamentService service;
	
	private LeagueService leagueService;
	
	private Tournament tournament;

	private List<Tournament> tournaments;
	
	private List<Tournament> tournamentsToBeListed;
	
	private List<Integer> tournamentLeaguesIds = new ArrayList<Integer>();
	
	Map<Integer, String> leagues = new HashMap<Integer, String>(); 
	 
	private Paginator paginatorService;
	
	private List<Integer> paginationItems;
	
	private int page = 1;
	
	private String searchParameter = null;
	
	private boolean search = false;
	
	private boolean listOfResultsLoaded = false;
	
	
	public String list() {
		
		loadResults();
		
		paginateResults();
		
		cleanTournamentLeaguesIds();
				
		return SUCCESS;
    }
			
    public String add() {
        setTournament(null);
        setLeagues(leagueService.findAll());
        
        return SUCCESS;
    }

    public String save() {
    	
    	/* Remove all the leagues stored in the collection, in order we can add the new ones selected (re-write). */
    	tournament.getLeagues().removeAll(tournament.getLeagues());
    	
    	/* Add to the collection all the leagues stored in tournamentLeaguesId List selected by the user and. */
    	for (Integer leagueId : tournamentLeaguesIds) {
    		tournament.getLeagues().add(leagueService.find(leagueId));
    	}
    	
    	service.save(tournament);
    	setListOfResultsLoaded(false);
    	
        return SUCCESS;
    }

    public String edit() {
    	
        setTournament(service.find(tournament.getId()));
        setLeagues(leagueService.findAll());
        cleanTournamentLeaguesIds();
        
        /* Add (load) to the tournamentLeaguesId List the leagues stored in the db. */
    	for (League league : tournament.getLeagues()) {
    		tournamentLeaguesIds.add(league.getId());
    	}
    	
        return SUCCESS;
    }

    public String activate() {
        service.remove(tournament.getId());
        setListOfResultsLoaded(false);
        return SUCCESS;
    }

    public String search() {
    	setSearch(true);
    	setListOfResultsLoaded(true);
    	setTournamentsToBeListed(service.findByParameter(searchParameter));
    	
    	return SUCCESS;
    }
    
	private void loadResults() {
		if (!listOfResultsLoaded) {
			if (search) {
				search();
			} else {
				listAll();
			}			
		}		
	}
	    
    /* 
     * Remove all the leagues stored in tournamentLeaguesIds List, in order we can load the ones stored in the db. 
     */
    private void cleanTournamentLeaguesIds() {
    	tournamentLeaguesIds.removeAll(tournamentLeaguesIds);
    }

	@SuppressWarnings("unchecked")
	private void paginateResults() {
		paginatorService.setNumberOfElementsToShow(10);
		
		setPaginationItems(
			paginatorService.createPaginationItems(getTournamentsToBeListed().size())
		);
		
		page = page > paginationItems.size() ? 1 : page;

		setTournaments(
			paginatorService.paginate(getTournamentsToBeListed(), page)
		);		
	}
	
	private void listAll() {
		
		setSearch(false);
		setListOfResultsLoaded(true);
		setTournamentsToBeListed(service.findAll());
	}
	
	public TournamentService getService() {
		return service;
	}

	public void setService(TournamentService service) {
		this.service = service;
	}
	
	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public List<Tournament> getTournamentsToBeListed() {
		return tournamentsToBeListed;
	}

	public void setTournamentsToBeListed(List<Tournament> tournamentsToList) {
		this.tournamentsToBeListed = tournamentsToList;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
	
	public List<Integer> getTournamentLeaguesIds() {
		return tournamentLeaguesIds;
	}

	public void setTournamentLeaguesIds(List<Integer> tournamentLeaguesId) {
		this.tournamentLeaguesIds = tournamentLeaguesId;
	}

	public Map<Integer, String> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
        for(League league : leagues) {
        	this.leagues.put(league.getId(), league.getName());
        }
	}

	public Paginator getPaginatorService() {
		return paginatorService;
	}

	public void setPaginatorService(Paginator paginatorService) {
		this.paginatorService = paginatorService;
	}

	public List<Integer> getPaginationItems() {
		return paginationItems;
	}

	public void setPaginationItems(List<Integer> paginationList) {
		this.paginationItems = paginationList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int p) {
		this.page = p;
	}

	public String getSearchParameter() {
		return searchParameter;
	}

	public void setSearchParameter(String searchParameter) {
		this.searchParameter = searchParameter;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean isSearch) {
		this.search = isSearch;
	}

	public boolean isListOfResultsLoaded() {
		return listOfResultsLoaded;
	}

	public void setListOfResultsLoaded(boolean listOfResultsLoaded) {
		this.listOfResultsLoaded = listOfResultsLoaded;
	}
	
}
