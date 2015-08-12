package com.iscool.admin.dao;

import com.iscool.admin.model.School;
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
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class SchoolDaoImpl implements SchoolDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(School school) {
        hibernateTemplate.persist(school);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(School school) {
        try {
            hibernateTemplate.merge(school);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(School school) {
        hibernateTemplate.delete(school);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public School getSchool(Long schoolId) {
        return hibernateTemplate.get(School.class, schoolId);
    }

    @Override
    public School getSchool(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(School) hibernateTemplate.find("from School where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<School> findAllSchool() {
        return hibernateTemplate.find("from School");     //HQL
    }

    @Override
    public List<School> findAllSchool(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from School where name=?", param);     //HQL
    }
}
