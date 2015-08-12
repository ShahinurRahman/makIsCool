package com.iscool.security.dao;

import java.util.List;

import com.iscool.security.model.Feature;
import com.iscool.security.model.Authority;
import com.iscool.security.model.Groups;
import com.iscool.security.model.Component;

public interface SecurityDao {
	
	public boolean save(Feature feature);

    public boolean update(Feature feature);

    public Feature findFeatureByOperation(String operation);

    public Feature getFeature(int featureId);
	
	public List<Feature> findAllFeatures();
	
	public boolean delete(Feature feature);
	
	public boolean save(Authority authority);

    public boolean update(Authority authority);

    public Authority getAuthority(int authorityId);
	
	public List<Authority> findAllAuthorities();
	
	public Authority findByAuthorityName(String authorityName);
	
	public boolean delete(Authority authority);
	
	public boolean save(Component component);

    public boolean update(Component component);

    public Component getComponent(int componentId);
	
	public List<Component> findAllComponents();

    public Component getComponentById(Long componentId);

    public Component getComponentByName(String componentName);
	
	public boolean delete(Component component);

    public boolean save(Groups groups);

    public boolean update(Groups groups);

    public Groups getAuthorizedGroups(int authorizedGroupId);
    
    public List<Groups> findAllAuthorizedGroups();
	
	public List<Authority> findAllAuthorities(List<Groups> groups);
	
	public List<Feature> findAllFeatures(List<Authority> authorities);
    
    public List<Groups> findAllAuthorizedGroup();
	
}
