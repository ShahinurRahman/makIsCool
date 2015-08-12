package com.iscool.admin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/17/15
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "AD_STUDENT")
//@DiscriminatorValue("student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String roll;

    private String batch;

    private String shift;

    private String department;

    private String session;

    private String guardian;

    private String age;

    private String sex;

    private String address;

    /*@Temporal(TemporalType.DATE)
    private Date admissionDate;*/

    private String contact;

    private String email;

    private String reference;


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

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
