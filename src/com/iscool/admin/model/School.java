package com.iscool.admin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/17/15
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="AD_SCHOOL")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address1;

    private String address2;

    private String description;

    @ManyToOne
    private City city;

    @OneToMany
    @JoinTable(name = "AD_SCHOOL_DEPARTMENT", joinColumns = @JoinColumn(name="SCHOOL_ID"),
            inverseJoinColumns = @JoinColumn(name="DEPARTMENT_ID"))

    List<Department> departmentList = new ArrayList<Department>();

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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
