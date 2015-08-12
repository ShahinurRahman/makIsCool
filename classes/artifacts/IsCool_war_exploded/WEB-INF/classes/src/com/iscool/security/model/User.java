

package com.iscool.security.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("admin")
@Table(name = "ABC_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 7389991231663740924L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private boolean active;

    @OneToOne
    private Token token;

	@ManyToMany
   /* @JoinTable(name = "ABC_JT_USER_GROUP",
            joinColumns = @JoinColumn(name = "USER"),
            inverseJoinColumns = @JoinColumn(name = "GROUP"))*/
	private List<Groups> groupList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Groups> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Groups> groupList) {
        this.groupList = groupList;
    }
}
