package com.iscool.admin.dao;

import com.iscool.admin.model.City;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/4/15
 * Time: 8:22 PM
 * To change this template use File | Settings | File Templates.
 */

public interface CityDAO {
    public boolean save(City city);

    public boolean update(City city);

    public boolean delete(City city);

    public City getCity(Long id);

    public City getCity(String query);

    public List<City> findAllCity();

    public List<City> findAllCity(String query);
}
