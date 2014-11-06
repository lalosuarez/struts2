package org.lalosuarez.app.dto;

import java.util.HashSet;
import java.util.Set;

public class League {
	
	private int id;
	
	private String name;
	
	private String logo;
	
	private boolean active = true;

	private Set<Tournament> tournaments = new HashSet<Tournament>();
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(Set<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
}
