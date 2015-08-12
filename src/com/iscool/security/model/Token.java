package com.iscool.security.model;

import com.iscool.security.DESEDE;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ABC_TOKEN", uniqueConstraints= @UniqueConstraint(columnNames={"username"}))
public class Token implements Serializable {
	
	
	private static final long serialVersionUID = -2020752748932592756L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String username;
	private String password;


    @OneToOne(mappedBy = "token")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
        DESEDE desede = new DESEDE(this.username);
        this.password = desede.encrypt(password);
	}



}
