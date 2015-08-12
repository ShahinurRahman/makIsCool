package com.iscool.security.service;

import java.util.List;

import com.iscool.security.model.Feature;
import com.iscool.security.model.Authority;
import com.iscool.security.model.Groups;
import com.iscool.security.model.Component;

public interface SecurityService {
	
	public boolean save(Feature feature);
	
	public List<Feature> findAllFeatures();
    
	public Feature findFeatureByOperation(String operation);
    
	public boolean delete(Feature feature);
  
	
	public boolean save(Authority authority);
	
	public List<Authority> findAllAuthorities();
	
	public Authority findByAuthorityName(String authorityName);
	
	public boolean delete(Authority authority);
	
	public boolean save(Component component);
	
	public List<Component> findAllComponents();
    
    public Component getComponentById(Long componentId);
    
    public Component getComponentByName(String componentName);
	
	public boolean delete(Component component);
	
	public List<Authority> findAllAuthorities(List<Groups> groups);
	
	public List<Feature> findAllFeatures(List<Authority> authorities);

    public boolean save(Groups groups);


    public List<Groups> findAllAuthorizedGroup();

}
