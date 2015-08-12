package com.iscool.admin.dao;

import com.iscool.admin.model.Teacher;
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
 * Time: 1:29 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class TeacherDaoImpl implements TeacherDAO{

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Teacher teacher) {
        hibernateTemplate.persist(teacher);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Teacher teacher) {
        try {
            hibernateTemplate.merge(teacher);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Teacher teacher) {
        hibernateTemplate.delete(teacher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Teacher getTeacher(Long teacherId) {
        return hibernateTemplate.get(Teacher.class, teacherId);
    }

    @Override
    public Teacher getTeacher(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(Teacher) hibernateTemplate.find("from Teacher where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return hibernateTemplate.find("from Teacher");     //HQL
    }

    @Override
    public List<Teacher> findAllTeacher(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from Teacher where name=?", param);     //HQL
    }
}
