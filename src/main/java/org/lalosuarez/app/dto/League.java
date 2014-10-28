package org.lalosuarez.app.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table (name="leagues")
public class League {
	
	@Id @GeneratedValue
	@Column (name="league_id")
	private int id;
	
	@Column (name="league_name")
	private String name;
	
	@Column (name="league_logo")
	private String logo;
	
	@Column (name="league_active")
	private boolean active = true;

	@ManyToMany (mappedBy="leagues", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@Cache (usage=CacheConcurrencyStrategy.TRANSACTIONAL)
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
