package com.iscool.security.dao;

import com.iscool.security.model.Authority;
import com.iscool.security.model.Groups;
import com.iscool.security.model.Feature;
import com.iscool.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthenticationAndAuthorizationDaoImpl implements
		AuthenticationAndAuthorizationDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public boolean authorizedGroupsAssignmentToUser(
			User user, List<Groups> groups) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean authorityAssignmentToAuthorizedGroups(
			Groups groups, List<Authority> authorities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean featureAssignmentToAuthority(Authority authority,
			List<Feature> features) {
		// TODO Auto-generated method stub
		return false;
	}

}
