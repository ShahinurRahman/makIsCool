package com.iscool.admin.dao;

import com.iscool.admin.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/3/15
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CountryDaoImpl implements CountryDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Country country) {
        hibernateTemplate.persist(country);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Country country) {
        try {
            hibernateTemplate.merge(country);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Country country) {
        hibernateTemplate.delete(country);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Country getCountry(Long id) {
        return hibernateTemplate.get(Country.class, id);
    }

    @Override
    public Country getCountry(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(Country) hibernateTemplate.find("from Country where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<Country> findAllCountry() {
        return hibernateTemplate.find("from Country");     //HQL
    }

    @Override
    public List<Country> findAllCountry(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from Country where name=?", param);     //HQL
    }

}
