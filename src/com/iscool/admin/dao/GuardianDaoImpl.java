package com.iscool.admin.dao;

import com.iscool.admin.model.Guardian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/18/15
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class GuardianDaoImpl implements GuardianDAO{

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Guardian guardian) {
        hibernateTemplate.persist(guardian);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Guardian guardian) {
        try {
            hibernateTemplate.merge(guardian);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Guardian guardian) {
        hibernateTemplate.delete(guardian);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Guardian getGuardian(Long guardianId) {
        return hibernateTemplate.get(Guardian.class, guardianId);
    }

    @Override
    public Guardian getGuardian(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(Guardian) hibernateTemplate.find("from Guardian where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<Guardian> findAllGuardian() {
        return hibernateTemplate.find("from Guardian");     //HQL
    }

    @Override
    public List<Guardian> findAllGuardian(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from Guardian where name=?", param);     //HQL
    }
}
