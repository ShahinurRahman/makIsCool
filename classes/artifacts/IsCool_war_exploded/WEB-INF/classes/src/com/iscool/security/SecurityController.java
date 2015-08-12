package com.iscool.security;

import com.iscool.util.CurrentUserCredentials;
import com.iscool.security.model.*;
import com.iscool.security.service.AuthenticationAndAuthorizationService;
import com.iscool.security.service.SecurityService;
import com.iscool.security.service.UserDetailsService;
import com.iscool.util.ERPConstants;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/security/")
public class SecurityController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SecurityService securityService;



    @Autowired
    private AuthenticationAndAuthorizationService authorizationService;
    private HttpSession userSession;

    @RequestMapping(method = RequestMethod.GET, value = "/home.cool")
    public ModelAndView index() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();


        //return new ModelAndView("/security/index", map);
        return new ModelAndView("template/app_layout", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/passwordRequest.cool")
    public ModelAndView passwordRequest() {
        Map<String, String> passwordRequestMap = new HashMap<String, String>();
        passwordRequestMap.put("success", "");

        return new ModelAndView("/security/password_request", passwordRequestMap);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userSummary.cool")
    public ModelAndView userSummary() {
        return new ModelAndView("/security/user_list");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout.cool")
    public ModelAndView logout() {
        userSession = SessionUtil.getSession();
        userSession.removeAttribute(ERPConstants.SESSION_USER);
        userSession.removeAttribute(ERPConstants.SESSION_USER_FEATURES);
        userSession.invalidate();
        return new ModelAndView("redirect:/home.cool");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/userAuthorizedGroupAssignment.cool")
    public ModelAndView userAuthorizedGroupAssignment() {
        System.out.println("assignment !!! ");
        return new ModelAndView("/security/user_list");
    }


    //=======USER=========START================================================
    @RequestMapping(method = RequestMethod.GET, value = "/createUser.cool")
    public ModelAndView createUser(@RequestParam("errMsg") String errMsg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "Create User");
        map.put("DashboardLink", ERPConstants.DASHBOARD_LINK);
        map.put("errMsg", errMsg);
        List<User> users = userDetailsService.getAllUsers();
        map.put("userList", users);

        return new ModelAndView("/security/user_create", map);

    }

    //Ajax Call
    @RequestMapping(value = "/checkDuplicateUser.cool", method = RequestMethod.GET)
    public
    @ResponseBody
    String checkDuplicateUser(@RequestParam("username") String username) {
        User user = userDetailsService.getUser(username);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        if (user != null) {
            map.put("msg", "Yes");
            map.put("name", "---TODO..");
        } else {
            map.put("msg", "No");
        }
        String json = gson.toJson(map);
        return json;
    }

    @RequestMapping(value = "/saveUser.cool", method = RequestMethod.GET)
    public
    @ResponseBody
    String saveUser(@RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("confirmPassword") String confirmPassword,
                    @RequestParam("userType") String userType) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        User userDuplicate = userDetailsService.findUserByUserCode(username);
        if (userDuplicate != null) {
            map.put("success", "no");
            map.put("msg", "This username already taken by " );
            String json = gson.toJson(map);
            return json;
        } else {
            if (password.equals(confirmPassword)) {
                Token userToken = new Token();
                userToken.setUsername(username);
                userToken.setPassword(password);
                userDetailsService.saveUser(userToken);
                map.put("success", "yes");
                map.put("msg", "User Saved Successfully");
                String json = gson.toJson(map);
                return json;
            } else {
                map.put("success", "no");
                map.put("msg", "Password doesn't match");
                String json = gson.toJson(map);
                return json;
            }
        }
    }

   /* @RequestMapping(method = RequestMethod.POST, value = "/saveUser.cool")
    public ModelAndView saveUser(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirmPassword") String confirmPassword,
                                 @RequestParam("userType") String userType) {
        Map<String, String> map = new HashMap<String, String>();
        User userDuplicate = userDetailsService.findUserByUserCode(username);
        if (userDuplicate != null) {
            String errMsg = "User already exists";
            //System.out.println("userDuplicate.getToken() = " + userDuplicate.getToken().getUsername());
            map.put("PageTitle", "User Create");
            return new ModelAndView("redirect:/security/createUser.cool?errMsg=" + errMsg, map);
        } else {
            if (password.equals(confirmPassword)) {
                Token userToken = new Token();
                userToken.setUsername(username);
                userToken.setPassword(password);

                userDetailsService.saveUser(userToken, userType);
                //System.out.println("userDuplicate.getToken() second case = " + userToken.getUsername());
                String errMsg = "";
                map.put("PageTitle", "User Create");

                return new ModelAndView("redirect:/security/createUser.cool?errMsg=" + errMsg, map);
            } else {
                String errMsg = "Password doesn't match";
                map.put("PageTitle", "User Create");


                return new ModelAndView("redirect:/security/createUser.cool?errMsg=" + errMsg, map);
            }

        }

    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/editUser.cool")
    public ModelAndView editUser(@RequestParam("id") Long id) {
        Map<String, Object> updateUserMap = new HashMap<String, Object>();
        User user;
        if (id == 0L) {
            user = new CurrentUserCredentials().user;
            id = user.getId();
        } else {
            user = userDetailsService.getUser(id);
        }
        updateUserMap.put("PageTitle", "Update User");
        updateUserMap.put("DashboardLink", ERPConstants.DASHBOARD_LINK);
        updateUserMap.put("userId", id);
        updateUserMap.put("userName", user.getToken().getUsername());

        return new ModelAndView("/security/user_edit", updateUserMap);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/userProfile.cool")
    public ModelAndView userProfile(@RequestParam("id") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user;
        if (id == 0L) {
            user = new CurrentUserCredentials().user;
            //id = user.getId();
        } else {
            user = userDetailsService.getUser(id);
        }
        map.put("PageTitle", "User Profile");
        map.put("DashboardLink", ERPConstants.DASHBOARD_LINK);
        map.put("user", user);

        return new ModelAndView("/hrm/user_profile", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUser.cool")
    public ModelAndView updateUser(@RequestParam("password") String password,
                                   @RequestParam("confirmPassword") String confirmPassword,
                                   @RequestParam("id") Long id) {
        Map<String, Object> updateUserMap = new HashMap<String, Object>();
        User user = userDetailsService.getUser(id);
        Token token = user.getToken();
        updateUserMap.put("PageTitle", "Update User");
        updateUserMap.put("DashboardLink", ERPConstants.DASHBOARD_LINK);

        if (password.equals(confirmPassword)) {
            token.setPassword(password);
            userDetailsService.updateToken(token);
        }
        return new ModelAndView("/security/success");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userList.cool")
    public ModelAndView userList() {
        System.out.println("userList");
        Map<String, String> userListMap = new HashMap<String, String>();
        userListMap.put("PageTitle", "User List");
        return new ModelAndView("redirect:/security/user_list", userListMap);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/deleteUser.cool")
    public ModelAndView deleteUser(@RequestParam("id") Long id) {
        userDetailsService.delete(userDetailsService.getUser(id));
        return new ModelAndView("redirect:/security/createUser.cool?errMsg=");

    }

    //=======USER=========END================================================


    @RequestMapping(method = RequestMethod.GET, value = "/createComponent.cool")
    public ModelAndView createComponent() {
        Map<String, String> createComponentMap = new HashMap<String, String>();
        createComponentMap.put("PageTitle", "Create Component");
        createComponentMap.put("DashboardLink", ERPConstants.DASHBOARD_LINK);

        return new ModelAndView("/security/create_component", createComponentMap);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComponent.cool")
    public ModelAndView saveComponent(@RequestParam("componentName") String componentName, @RequestParam("description") String description) {
        Map<String, String> saveComponentMap = new HashMap<String, String>();
        Component componentDuplicate = securityService.getComponentByName(componentName);
        if (componentDuplicate != null) {
            saveComponentMap.put("result", "Component already exists");
            saveComponentMap.put("PageTitle", "Component Create");
            return new ModelAndView("redirect:/security/componentList.cool", saveComponentMap);
        } else {
            Component component = new Component();
            component.setComponentName(componentName);
            component.setDescription(description);
            securityService.save(component);
            saveComponentMap.put("PageTitle", "Create Component");

            return new ModelAndView("redirect:/security/createComponent.cool", saveComponentMap);

        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveAuthorizedGroups")
    public ModelAndView saveAuthorizedGroups(@RequestParam("authorizationName") String authorizationName,
                                             @RequestParam("authorizationDescription") String authorizationDescription) {

        Map<String, String> saveAuthorizedGroupsMap = new HashMap<String, String>();
        Groups groupsDuplicate = userDetailsService.findByAuthorizedGroupsName(authorizationName);

        if (groupsDuplicate != null) {
            saveAuthorizedGroupsMap.put("result", "Group already exists!!!");

            return new ModelAndView("/security/user_group_create", saveAuthorizedGroupsMap);
        } else {
            Groups groups = new Groups();
            groups.setName(authorizationName);
            groups.setDescription(authorizationDescription);

            userDetailsService.saveAuthorizedGroups(groups);

            saveAuthorizedGroupsMap.put("result", "Authorized Group is saved successfully!!!");

            return new ModelAndView("/security/user_group_create", saveAuthorizedGroupsMap);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createAuthority.cool")
    public ModelAndView createAuthority() {
        Map<String, String> createAuthorityMap = new HashMap<String, String>();
        createAuthorityMap.put("PageTitle", "Create Authority");
        createAuthorityMap.put("DashboardLink", "../home.cool");
        return new ModelAndView("/security/create_authority", createAuthorityMap);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveAuthority.cool")
    public ModelAndView saveAuthority(@RequestParam("authorityName") String authorityName,
                                      @RequestParam("authorityDescription") String authorityDescription) {
        Map<String, String> saveAuthorityMap = new HashMap<String, String>();
        Authority authorityDuplicate = securityService.findByAuthorityName(authorityName);

        if (authorityDuplicate != null) {
            saveAuthorityMap.put("result", "Authority already exists!!!");
            saveAuthorityMap.put("PageTitle", "Create Authority");
            return new ModelAndView("redirect:/security/createAuthority.cool", saveAuthorityMap);
        } else {
            Authority authority = new Authority();
            authority.setName(authorityName);
            authority.setDescription(authorityDescription);

            securityService.save(authority);
            saveAuthorityMap.put("PageTitle", "Create Authority");
            return new ModelAndView("redirect:/security/createAuthority.cool", saveAuthorityMap);
        }
    }

    //========Component Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/componentList.cool")
    public ModelAndView componentList() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "Component");
        map.put("DashboardLink", ERPConstants.DASHBOARD_LINK);

        List<Component> componentList = securityService.findAllComponents();
        map.put("componentList", componentList);

        return new ModelAndView("/security/component", map);
    }

    //========Authority Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/authorityList.cool")
    public ModelAndView authorityList() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "Authority");
        map.put("DashboardLink", ERPConstants.DASHBOARD_LINK);
        List<Authority> authorityList = securityService.findAllAuthorities();
        map.put("authorityList", authorityList);
        return new ModelAndView("/security/authority", map);
    }

    //========Group Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/userGroupList.cool")
    public ModelAndView userGroupList() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "User Group");
        map.put("DashboardLink", ERPConstants.DASHBOARD_LINK);

        List<Groups> groupsList = securityService.findAllAuthorizedGroup();
        map.put("groupsList", groupsList);
        return new ModelAndView("/security/group", map);
    }

    //========Feature Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/featureList.cool")
    public ModelAndView featureList() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "Feature");
        map.put("DashboardLink", ERPConstants.DASHBOARD_LINK);

        List<Feature> featureLists = securityService.findAllFeatures();
        map.put("featureLists", featureLists);

        List<Component> componentList = securityService.findAllComponents();
        map.put("componentList", componentList);

        return new ModelAndView("/security/feature", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveFeature.cool")
    public ModelAndView saveFeature(@RequestParam("description") String description,
                                    @RequestParam("operation") String operation,
                                    @RequestParam("componentId") Long componentId) {
        Map<String, String> map = new HashMap<String, String>();
        Feature featureOperationDuplicate = securityService.findFeatureByOperation(operation);
        if (featureOperationDuplicate != null) {

            map.put("result", "User already exists");
            map.put("PageTitle", "Feature");
            return new ModelAndView("redirect:/security/featureList.cool", map);

        } else {
            //Long componentIdNumber = Long.valueOf(componentId);
            Component component = securityService.getComponentById(componentId);
            Authority superAdminAuthority = securityService.findByAuthorityName("super_admin");
            Feature feature = new Feature();
            feature.setDescription(description);
            feature.setOperation(operation);
            feature.setComponent(component);
            superAdminAuthority.getFeatureList().add(feature);

            securityService.save(feature);
            map.put("PageTitle", "Feature");

            return new ModelAndView("redirect:/security/featureList.cool", map);

        }
    }

}