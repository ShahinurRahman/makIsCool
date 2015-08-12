package com.iscool.admin.dao;

import com.iscool.admin.model.School;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/18/15
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SchoolDAO {
    public boolean save(School school);

    public boolean update(School school);

    public boolean delete(School school);

    public School getSchool(Long schoolId);

    public School getSchool(String query);

    public List<School> findAllSchool();

    public List<School> findAllSchool(String query);
}
