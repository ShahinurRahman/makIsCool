package com.iscool.admin.dao;

import com.iscool.admin.model.Country;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/3/15
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CountryDAO {
    public boolean save(Country country);

    public boolean update(Country country);

    public boolean delete(Country country);

    public Country getCountry(Long countryId);

    public Country getCountry(String query);

    public List<Country> findAllCountry();

    public List<Country> findAllCountry(String query);
}
