package com.iscool.security.dao;

import java.util.List;

import com.iscool.security.model.Feature;
import com.iscool.security.model.Authority;
import com.iscool.security.model.Groups;
import com.iscool.security.model.User;

public interface AuthenticationAndAuthorizationDao {

	public boolean authorizedGroupsAssignmentToUser(User user, List<Groups> groups);
	
	public boolean authorityAssignmentToAuthorizedGroups(Groups groups, List<Authority> authorities);
	
	public boolean featureAssignmentToAuthority(Authority authority, List<Feature> features);

}
