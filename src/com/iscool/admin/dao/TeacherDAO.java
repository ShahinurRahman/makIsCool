package com.iscool.admin.dao;

import com.iscool.admin.model.Teacher;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/18/15
 * Time: 1:29 AM
 * To change this template use File | Settings | File Templates.
 */


public interface TeacherDAO {
    public boolean save(Teacher teacher);

    public boolean update(Teacher teacher);

    public boolean delete(Teacher teacher);

    public Teacher getTeacher(Long teacherId);

    public Teacher getTeacher(String query);

    public List<Teacher> findAllTeacher();

    public List<Teacher> findAllTeacher(String query);
}
