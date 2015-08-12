package com.iscool.admin.dao;

import com.iscool.admin.model.Region;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/4/15
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RegionDAO {
    public boolean save(Region region);

    public boolean update(Region region);

    public boolean delete(Region region);

    public Region getRegion(Long regionId);

    public Region getRegion(String query);

    public List<Region> findAllRegions();

    public List<Region> findAllRegions(String query);

}
