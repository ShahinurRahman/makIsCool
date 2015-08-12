package com.iscool.security.dao;

import com.iscool.security.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AuthorizedGroupsDaoImpl implements AuthorizedGroupsDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Groups groups) {
        try {
            hibernateTemplate.persist(groups);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Groups groups) {
        hibernateTemplate.merge(groups);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Groups groups) {
        hibernateTemplate.delete(groups);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Groups> findAllAuthorizedGroups() {
        return hibernateTemplate.find("from AuthorizedGroups");
    }

    @Override
    public Groups getAuthorizedGroups(Long id) {
        return hibernateTemplate.get(Groups.class, id);
    }
}
