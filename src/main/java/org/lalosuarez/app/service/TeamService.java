package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dto.Team;

public interface TeamService {

    public List<Team> findAll();
    
    public void save(Team object);
 
    public void remove(int id);
 
    public Team find(int id);
}
