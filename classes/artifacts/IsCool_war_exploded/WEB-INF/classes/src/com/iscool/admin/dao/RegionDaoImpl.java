package com.iscool.admin.dao;

import com.iscool.admin.model.Region;
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
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RegionDaoImpl implements RegionDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;



    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Region region) {
        hibernateTemplate.persist(region);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Region region) {
        try {
            hibernateTemplate.merge(region);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Region region) {
        hibernateTemplate.delete(region);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Region getRegion(Long regionId) {
        return hibernateTemplate.get(Region.class, regionId);
    }

    @Override
    public Region getRegion(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(Region) hibernateTemplate.find("from Region where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<Region> findAllRegions() {
        return hibernateTemplate.find("from Region");     //HQL
    }

    @Override
    public List<Region> findAllRegions(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from Region where name=?", param);     //HQL
    }


}
