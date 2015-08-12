package com.iscool.security.dao;

import com.iscool.security.model.Groups;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorizedGroupsDAO {
    public boolean save(Groups groups);

    public boolean update(Groups groups);

    public boolean delete(Groups groups);

    public List<Groups> findAllAuthorizedGroups();

    public Groups getAuthorizedGroups(Long id);

}
