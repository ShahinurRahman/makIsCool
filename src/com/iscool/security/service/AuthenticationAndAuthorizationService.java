package com.iscool.security.service;

import java.util.List;

import com.iscool.security.model.*;

public interface AuthenticationAndAuthorizationService {
	
	public boolean authenticate(String username, String password);
	
	public boolean checkAuthorization(List<Feature> features, String controller, String operation);
	
	public boolean authorizedGroupsAssignmentToUser(User user, List<Groups> groups);
	
	public boolean authorityAssignmentToAuthorizedGroups(Groups groups, List<Authority> authorities);
	
	public boolean aspectAssignmentToAuthority(Authority authority, List<Feature> features);

    //Authorized Groups
    public Groups getAuthorizedGroups(Long id);
    public List<Groups> findAllAuthorizedGroups();

}
