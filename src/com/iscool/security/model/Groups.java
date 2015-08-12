package com.iscool.security.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ABC_GROUP")
public class Groups implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "groupList")
	private List<User> userList;

    @ManyToMany
  /*  @JoinTable(name = "ABC_JT_GROUP_AUTHORITY",
            joinColumns = @JoinColumn(name = "GROUP"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY"))*/
	private List<Authority> authorityList;
	
	
	public List<Authority> getAuthorityList() {
		return authorityList;
	}
	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
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
