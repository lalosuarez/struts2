package org.lalosuarez.app.dao;

import java.util.List;

import org.lalosuarez.app.dto.League;

public interface LeagueDao {
    public List<League> findAll();
    
    public void save(League object);
 
    public void remove(int id);
 
    public League find(int id);
}
