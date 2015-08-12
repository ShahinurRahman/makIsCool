package com.iscool.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.iscool.security.model.Authority;
import com.iscool.security.model.Groups;
import com.iscool.security.model.Feature;
import com.iscool.security.model.User;
import com.iscool.security.service.UserDetailsService;
import com.iscool.util.ERPConstants;


/**
 * This class contains the functionality to find out user's authorized groups,
 * authorities and authorized features and store them into session attributes. 
 *
 */
public class AuthorizationToken {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	public User principal;
	public List<Authority> credentials;
	public List<Groups> groups;
	public List<Feature> authorities;
	public List<Feature> grantedAuthorities;
	
		
	public AuthorizationToken(User user) {
		setAuthenticationToken(user);
	}
	
	/**
	 * This method contains the functionality to find out user's authorized groups,
	 * authorities and authorized features and store them into session attributes.
	 * @param principal
	 * 		The logged in user object.
	 */
	public void setAuthenticationToken(User principal){

		if(principal != null){
			
			HttpSession session = SessionUtil.getSession();

			session.setAttribute(ERPConstants.SESSION_USER, principal);

			groups = principal.getGroupList();

			grantedAuthorities = new ArrayList<Feature>();
			
			if(groups != null){
				for(Groups authorizedGroup : groups){
					credentials = authorizedGroup.getAuthorityList();
					for(Authority authority : credentials){
						authorities = authority.getFeatureList();
						grantedAuthorities.addAll(authorities);
					}
				}
			}
			
			session.setAttribute(ERPConstants.SESSION_USER_FEATURES, grantedAuthorities);
		}
		
		// get the list of authorized groups, authorities and aspects and put them in session.
	}
	

}
