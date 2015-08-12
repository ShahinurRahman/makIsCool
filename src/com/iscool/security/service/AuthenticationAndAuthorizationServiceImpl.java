package com.iscool.security.service;

import com.iscool.security.AuthorizationFilter;
import com.iscool.security.SessionUtil;
import com.iscool.security.dao.AuthorizedGroupsDAO;
import com.iscool.security.dao.UserDao;
import com.iscool.security.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationAndAuthorizationServiceImpl implements
		AuthenticationAndAuthorizationService {
	
	@Autowired
	private UserDao userDao;
    @Autowired
    AuthorizedGroupsDAO authorizedGroupsDao;
	@Override
	public boolean authenticate(String username, String password) {
		// call dao method to retrieve the user object
		User user = userDao.get(username, password);
		
		if(user instanceof User){
			// call authenticationfilter
			AuthorizationFilter.setAuthorization(user);
			
			return true;
		}		
		return false;
	}

	@Override
	public boolean checkAuthorization(List<Feature> features, String controller, String operation) {
        boolean isAllowed = false;
        for(Feature feature : SessionUtil.getSessionUserFeatures()){
            //System.out.println("controller " + controller + " feature.getComponent().getComponentName()" + feature.getComponent().getComponentName());
            if(feature.getComponent().getComponentName().equals(controller)
                    && feature.getOperation().equals(operation)){
                isAllowed = true;
                break;
            }
        }
		return isAllowed;
	}

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
	public boolean aspectAssignmentToAuthority(Authority authority,
			List<Feature> features) {
		// TODO Auto-generated method stub
		return false;
	}


    // Groups

    @Override
    public Groups getAuthorizedGroups(Long id) {
        return authorizedGroupsDao.getAuthorizedGroups(id);
    }

    @Override
    public List<Groups> findAllAuthorizedGroups() {
        return authorizedGroupsDao.findAllAuthorizedGroups();
    }
}
