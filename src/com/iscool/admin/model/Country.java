package com.iscool.admin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/26/15
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "AD_COUNTRY")
public class Country  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Region region;

    @OneToMany
    @JoinTable(name = "AD_CITY_COUNTRY", joinColumns = @JoinColumn(name="CITY_ID"),
            inverseJoinColumns = @JoinColumn(name="COUNTRY_ID"))

    List<City> cityList = new ArrayList<City>();

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
