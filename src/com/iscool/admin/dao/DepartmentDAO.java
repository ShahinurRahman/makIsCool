package com.iscool.admin.dao;

import com.iscool.admin.model.Department;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/18/15
 * Time: 1:20 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentDAO {
    public boolean save(Department department);

    public boolean update(Department department);

    public boolean delete(Department department);

    public Department getDepartment(Long departmentId);

    public Department getDepartment(String query);

    public List<Department> findAllDepartment();

    public List<Department> findAllDepartment(String query);
}
