package com.iscool.admin.dao;

import com.iscool.admin.model.Department;
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
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class DepartmentDaoImpl implements DepartmentDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Department department) {
        hibernateTemplate.persist(department);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Department department) {
        try {
            hibernateTemplate.merge(department);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Department department) {
        hibernateTemplate.delete(department);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Department getDepartment(Long id) {
        return hibernateTemplate.get(Department.class, id);
    }

    @Override
    public Department getDepartment(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(Department) hibernateTemplate.find("from Department where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<Department> findAllDepartment() {
        return hibernateTemplate.find("from Department");     //HQL
    }

    @Override
    public List<Department> findAllDepartment(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from Department where name=?", param);     //HQL
    }
}
