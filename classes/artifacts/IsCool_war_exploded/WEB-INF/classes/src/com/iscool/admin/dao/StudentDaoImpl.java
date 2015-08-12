package com.iscool.admin.dao;

import com.iscool.admin.model.Student;
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
public class StudentDaoImpl implements StudentDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Student student) {
        hibernateTemplate.persist(student);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Student student) {
        try {
            hibernateTemplate.merge(student);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Student student) {
        hibernateTemplate.delete(student);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Student getStudent(Long studentId) {
        return hibernateTemplate.get(Student.class, studentId);
    }

    @Override
    public Student getStudent(String query) {
        Object[] param = new Object[1];
        param[0] = query;
        try {
            return null; //(Student) hibernateTemplate.find("from Student where name = ?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public List<Student> findAllStudent() {
        return hibernateTemplate.find("from Student");     //HQL
    }

    @Override
    public List<Student> findAllStudent(String query) {
        Object[] param = new Object[1];
        param[0] = "%" + query + "%";
        return null; //hibernateTemplate.find("from Student where name=?", param);     //HQL
    }

}
