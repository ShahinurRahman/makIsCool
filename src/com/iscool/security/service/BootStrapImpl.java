package com.iscool.security.service;

import com.iscool.security.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ronnie
 * Date: 6/30/12
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class BootStrapImpl implements BootStrap {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserDetailsService userDetailsService;


    private List<Feature> features;
    private List<Authority> authorities;
    private List<Groups> authorizedCumulativeGroups;


    public void createDefaultAdmin(){
        System.out.println("userDetailsService.count() = " + userDetailsService.count());
        if(userDetailsService.count() == 0){

            Token token = new Token();
            token.setUsername("admin");
            token.setPassword("asadmin");

            userDetailsService.saveUser(token);

            //userDetailsService.update(token);
            User user = userDetailsService.findByUsername("admin");
            List<Groups> groups = initializeDefaultSecurityData();
            user.setGroupList(groups);

            userDetailsService.saveUser(user);
        }
    }

    @Override
    public boolean createComponents() {
        return false;
    }

    public boolean createFeatures(){
        return false;
    }


    public List<Groups> initializeDefaultSecurityData(){

        Component securityComponent = new Component();
        securityComponent.setComponentName("security");
        securityComponent.setDescription("Security Related Module");
        securityService.save(securityComponent);

        Component adminComponent = new Component();
        adminComponent.setComponentName("admin");
        adminComponent.setDescription("Admin Related Module");
        securityService.save(adminComponent);

        features = new ArrayList<Feature>();

        Feature saveFeature = new Feature();
        saveFeature.setComponent(securityComponent);
        saveFeature.setOperation("saveUser");
        saveFeature.setDescription("Saving User Feature");
        securityService.save(saveFeature);
        features.add(saveFeature);

        Feature createFeature = new Feature();
        createFeature.setComponent(securityComponent);
        createFeature.setOperation("createUser");
        createFeature.setDescription("Creating User Feature");
        securityService.save(createFeature);
        features.add(createFeature);

        Feature featureList = new Feature();
        featureList.setComponent(securityComponent);
        featureList.setOperation("featureList");
        featureList.setDescription("Creating User Feature");
        securityService.save(featureList);
        features.add(featureList);

        Feature userListFeature = new Feature();
        userListFeature.setComponent(securityComponent);
        userListFeature.setOperation("userList");
        userListFeature.setDescription("Listing all User Feature");
        securityService.save(userListFeature);
        features.add(userListFeature);

        Feature userJsonDataFeature = new Feature();
        userJsonDataFeature.setComponent(securityComponent);
        userJsonDataFeature.setOperation("userJsonData");
        userJsonDataFeature.setDescription("User List Json Data");
        securityService.save(userJsonDataFeature);
        features.add(userJsonDataFeature);


        Authority authority = new Authority();
        authority.setName("super_admin");
        authority.setDescription("Super Admin Authority");
        authority.setFeatureList(features);
        securityService.save(authority);
        authorities = new ArrayList<Authority>();
        authorities.add(authority);

        Groups groups = new Groups();
        groups.setName("System Engineer Group");
        groups.setDescription("Engineering the whole system having this privilege");
        groups.setAuthorityList(authorities);
        securityService.save(groups);

        authorizedCumulativeGroups = new ArrayList<Groups>();
        authorizedCumulativeGroups.add(groups);

        return authorizedCumulativeGroups;


    }
}
