package org.lalosuarez.app.dto;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table (name="teams")
public class Team {
    
    @Id @GeneratedValue
    @Column (name="team_id")
    private int id;
    
    @Column (name="team_name")
    private String name;
    
    @Column (name="team_iso")
    private String iso;
    
    @OneToOne
    @JoinColumn (name="league_id")
    private League league;
    
    @Column (name="team_logo")
    private String logo;
    
    @Column (name="team_active")
    private boolean active = true;
    
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
    
    public int getId() {
        return id;
    }
    
	public void setId(int id) {
		this.id = id;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
}
