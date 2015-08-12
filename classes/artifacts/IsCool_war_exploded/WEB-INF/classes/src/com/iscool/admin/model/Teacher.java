package com.iscool.admin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/17/15
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="AD_TEACHER")
//@DiscriminatorValue("teacher")
public class Teacher implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String designation;

    private String department;

    private String address;

    private String contact;

    private String email;

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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
