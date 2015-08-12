

package com.iscool.security.model;

import org.hibernate.annotations.CollectionOfElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ABC_USER_GROUP")
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 7389991231663740924L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name="group_name")
    private String name;

    @ManyToMany
    @CollectionOfElements
    private Set<User> userList = new HashSet<User>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }


}
