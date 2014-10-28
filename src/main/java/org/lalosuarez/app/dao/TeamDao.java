package org.lalosuarez.app.dao;

import java.util.List;

import org.lalosuarez.app.dto.Team;

public interface TeamDao {

    public List<Team> findAll();
    
    public void save(Team object);
 
    public void remove(int id);
 
    public Team find(int id);
    
}
