package org.lalosuarez.app.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lalosuarez.app.dto.Role;
import org.lalosuarez.app.dto.User;
import org.lalosuarez.app.service.RoleService;
import org.lalosuarez.app.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

	private UserService service;
	
	private RoleService roleService;
	
	private BCryptPasswordEncoder encoder;
	
	private User user;

	private List<User> users;
	
	private Role role;
	
	private List<Role> roles;
	 
	Map<Integer, String> rolesCollection;
	
	private String id;
	
    public String list() {
    	setUsers(getService().findAll());
    	
        return SUCCESS;
    }

    public String add() {
        setUser(null);
        setRole(null);
        setRoles(getRoleService().findAll());
        setRolesCollection(getRoles());
		
        return SUCCESS;
    }

    public String save() {

    	getUser().setPassword(getEncoder().encode(getUser().getPassword()));
    	getUser().setRole(getRoleService().find(getRole().getRoleId()));
        getService().save(getUser());
        
        return SUCCESS;
    }

    public String edit() {

    	setRoles(getRoleService().findAll());
        setRolesCollection(getRoles());    	
        setUser(getService().find(getId()));

        return SUCCESS; 
    }

    public String activate() {
        getService().remove(getId());
        return SUCCESS;
    }

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public BCryptPasswordEncoder getEncoder() {
		return encoder;
	}

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Map<Integer, String> getRolesCollection() {
		return rolesCollection;
	}

	public void setRolesCollection(List<Role> roles) {
        rolesCollection = new HashMap<Integer, String>();
        for(Role role : roles) {
        	rolesCollection.put(role.getRoleId(), role.getRole());
        }
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
