package com.iscool.admin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/26/15
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="AD_REGION")
public class Region  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String location;

    @OneToMany
    @JoinTable(name = "AD_REGION_COUNTRY", joinColumns = @JoinColumn(name="REGION_ID"),
    inverseJoinColumns = @JoinColumn(name="COUNTRY_ID"))

    List<Country> countryList = new ArrayList<Country>();

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

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
