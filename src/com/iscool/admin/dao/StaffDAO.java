package com.iscool.admin.dao;

import com.iscool.admin.model.Staff;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/18/15
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StaffDAO {
    public boolean save(Staff staff);

    public boolean update(Staff staff);

    public boolean delete(Staff staff);

    public Staff getStaff(Long staffId);

    public Staff getStaff(String query);

    public List<Staff> findAllStaff();

    public List<Staff> findAllStaff(String query);
}
