package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dto.League;

public interface LeagueService {

    public List<League> findAll();
    
    public void save(League object);
 
    public void remove(int id);
 
    public League find(int id);
}
