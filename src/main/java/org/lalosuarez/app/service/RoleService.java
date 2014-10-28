package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dto.Role;

public interface RoleService {

    public List<Role> findAll();
    
    public void save(Role object);
 
    public void remove(int id);
    
	public Role find(int id);
	
}
