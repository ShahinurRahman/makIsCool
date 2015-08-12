package com.iscool.admin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/17/15
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="AD_GUARDIAN")
//@DiscriminatorValue("guardian")
public class Guardian implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String designation;

    private String description;

    private String contact;

    private String email;

    //private List<Student> students = new ArrayList<Student>();


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
