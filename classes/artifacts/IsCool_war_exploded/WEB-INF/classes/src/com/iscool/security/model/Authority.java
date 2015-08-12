package com.iscool.security.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ABC_AUTHORITY")
public class Authority implements Serializable{
	
	private static final long serialVersionUID = -7056246735190005660L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "authorityList")
	private List<Groups> groupsList;
	
	@ManyToMany
    @JoinTable(name = "ABC_JT_AUTHORITY_FEATURE",
            joinColumns = @JoinColumn(name = "AUTHORITY"),
            inverseJoinColumns = @JoinColumn(name = "FEATURE"))
	private List<Feature> featureList;

	public List<Feature> getFeatureList() {
		return featureList;
	}
	public void setFeatureList(List<Feature> featureList) {
		this.featureList = featureList;
	}
	public List<Groups> getGroupsList() {
		return groupsList;
	}
	public void setGroupsList(List<Groups> groupsList) {
		this.groupsList = groupsList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
