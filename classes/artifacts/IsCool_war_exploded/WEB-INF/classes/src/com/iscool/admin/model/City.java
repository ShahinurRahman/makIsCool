
package com.iscool.admin.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/4/15
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="AD_CITY")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer zip;

    @ManyToOne
    private Country country;

    @OneToMany
    @JoinTable(name = "AD_CITY_SCHOOL", joinColumns = @JoinColumn(name="CITY_ID"),
            inverseJoinColumns = @JoinColumn(name="SCHOOL_ID"))

    List<School> cityList = new ArrayList<School>();

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

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<School> getCityList() {
        return cityList;
    }

    public void setCityList(List<School> cityList) {
        this.cityList = cityList;
    }
}

