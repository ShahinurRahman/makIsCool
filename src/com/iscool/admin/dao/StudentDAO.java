package com.iscool.admin.dao;

import com.iscool.admin.model.Student;
import com.iscool.admin.model.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/18/15
 * Time: 1:28 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StudentDAO {
    public boolean save(Student student);

    public boolean update(Student student);

    public boolean delete(Student student);

    public Student getStudent(Long studentId);

    public Student getStudent(String query);

    public List<Student> findAllStudent();

    public List<Student> findAllStudent(String query);
}
