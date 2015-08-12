package com.iscool.admin.dao;

import com.iscool.admin.model.Guardian;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/18/15
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GuardianDAO {
    public boolean save(Guardian guardian);

    public boolean update(Guardian guardian);

    public boolean delete(Guardian guardian);

    public Guardian getGuardian(Long guardianId);

    public Guardian getGuardian(String query);

    public List<Guardian> findAllGuardian();

    public List<Guardian> findAllGuardian(String query);
}
