package org.lalosuarez.app.dao;

import java.util.List;

import org.lalosuarez.app.dto.Tournament;

public interface TournamentDao {

    public List<Tournament> findAll();
    
    public void save(Tournament object);
 
    public void remove(int id);
 
    public Tournament find(int id);
    
    public List<Tournament> findByNumberOfResults(int start, int max);
    
    public List<Tournament> findByParameter(String searchParameter);
}
