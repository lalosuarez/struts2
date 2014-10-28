package org.lalosuarez.app.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table (name="tournaments")
public class Tournament {
	
	@Id @GeneratedValue
	@Column (name="tournament_id")
	private int id;
	
	@Column (name="tournament_name")
	private String name;
	
	@Column (name="tournament_type")
	private String type;
	
	@Column (name="tournament_logo")
	private String logo;
	
	@Column (name="tournament_enabled")
	private boolean enabled = true;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinTable(
	    name="tournaments_leagues",
	    joinColumns = {@JoinColumn (name="tournament_id")},
		inverseJoinColumns = {@JoinColumn (name="league_id") })
	@Cache (usage=CacheConcurrencyStrategy.TRANSACTIONAL)
	private Set<League> leagues = new HashSet<League>();
	
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(Set<League> leagues) {
		this.leagues = leagues;
	}

}
