package com.iscool.admin.dao;

import com.iscool.admin.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/4/15
 * Time: 8:22 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CityDaoImpl implements CityDAO{
    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(City city) {
        hibernateTemplate.persist(city);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(City city) {
        try {
            hibernateTemplate.merge(city);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(City city) {
        hibernateTemplate.delete(city);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public City getCity(Long cityId) {
        return hibernateTemplate.get(City.class, cityId);
    }

    @Override
    public City getCity(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(City) hibernateTemplate.find("from City where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<City> findAllCity() {
        return hibernateTemplate.find("from City");     //HQL
    }

    @Override
    public List<City> findAllCity(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from City where name=?", param);     //HQL
    }

}
