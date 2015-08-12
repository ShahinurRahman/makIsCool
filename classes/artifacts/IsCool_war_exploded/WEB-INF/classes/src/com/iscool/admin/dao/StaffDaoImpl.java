package com.iscool.admin.dao;

import com.iscool.admin.model.Staff;
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
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class StaffDaoImpl implements StaffDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Staff staff) {
        hibernateTemplate.persist(staff);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Staff staff) {
        try {
            hibernateTemplate.merge(staff);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Staff staff) {
        hibernateTemplate.delete(staff);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Staff getStaff(Long staffId) {
        return hibernateTemplate.get(Staff.class, staffId);
    }

    @Override
    public Staff getStaff(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(Staff) hibernateTemplate.find("from Staff where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<Staff> findAllStaff() {
        return hibernateTemplate.find("from Staff");     //HQL
    }

    @Override
    public List<Staff> findAllStaff(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from Staff where name=?", param);     //HQL
    }
}
