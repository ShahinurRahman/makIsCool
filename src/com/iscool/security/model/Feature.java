package com.iscool.security.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="ABC_FEATURE")
public class Feature implements Serializable {
	
	private static final long serialVersionUID = 8506032467669918398L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long featureId;
	
	@ManyToOne
	private Component component;
    private String operation;
    private String description;
    
    @ManyToMany(mappedBy = "featureList")
    private List<Authority> authorityList;
    
    
	public List<Authority> getAuthorityList() {
		return authorityList;
	}
	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}
	public Long getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
