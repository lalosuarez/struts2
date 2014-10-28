package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dto.User;

public interface UserService {

    public List<User> findAll();
    
    public void save(User object);
 
    public void remove(String username);
    
	public User find(String username);
	
}
