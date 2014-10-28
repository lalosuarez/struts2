package org.lalosuarez.app.action;

import java.util.List;

import org.lalosuarez.app.dto.Role;
import org.lalosuarez.app.service.RoleService;

import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

	private RoleService service;
	
	private List<Role> roles;
	
	public String getAllJson() {
		setRoles(service.findAll());	
		return SUCCESS;
	}

	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
