package com.iscool.security;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.iscool.security.model.Groups;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.iscool.security.model.Feature;
import com.iscool.security.model.Authority;
import com.iscool.security.model.User;
import com.iscool.util.ERPConstants;

public class SessionUtil {
	
	public static HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
	/**
	 * Retrieves the logged-in user object
	 * @return User
	 * The logged-in user object
	 */
	public static User getSessionUser(){
		
		User user = (User) getSession().getAttribute(ERPConstants.SESSION_USER);
		if(user instanceof User){
			return user;
		}
		return null;
	}
	
	/**
	 * Retrieves the logged-in user 
	 * @return Long
	 * The logged-in user id
	 */
	public static Long getSessionUserId(){
		
		Long userId = (Long) getSession().getAttribute(ERPConstants.SESSION_USER_ID);
		if(userId instanceof Long){
			return userId;
		}
		return null;
	}

	/**
	 * Retrieves the logged-in user groups
	 * @return List<Groups>
	 * The list of authorized user groups for the session user.
	 */
	public static List<Groups> getSessionUserAuthorizedGroups(){
		
		List<Groups> groups = (List<Groups>) getSession().getAttribute(ERPConstants.SESSION_USER_AUTHORIZED_GROUPS);
		if(groups != null){
			return groups;
		}
		return null;
	}
	
	/**
	 * Retrieves the logged-in user authorities
	 * @return List<Authority>
	 * The list of authorities for the session user.
	 */
	public static List<Authority> getSessionUserAuthorities(){
		
		List<Authority>  authorities = (List<Authority>) getSession().getAttribute(ERPConstants.SESSION_USER_AUTHORITIES);
		if(authorities != null){
			return authorities;
		}
		return null;
	}
	
	/**
	 * Retrieves the logged-in user aspects
	 * @return List<Feature>
	 * The list of authorities for the session user.
	 */
	public static List<Feature> getSessionUserFeatures(){
		List<Feature>  features = (List<Feature>) getSession().getAttribute(ERPConstants.SESSION_USER_FEATURES);
		if(features != null){
			return features;
		}
		return null;
	}
}
