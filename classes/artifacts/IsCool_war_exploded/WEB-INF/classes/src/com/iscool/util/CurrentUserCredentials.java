package com.iscool.util;

import com.iscool.security.SessionUtil;
import com.iscool.security.model.Groups;
import com.iscool.security.model.User;

import java.util.List;

public class CurrentUserCredentials {
    public User user = SessionUtil.getSessionUser();
    public String userPassword = user.getToken().getPassword();
    public String username =   user.getToken().getUsername();
    public Long authorizeId = user.getId();
    public List<Groups> groups = user.getGroupList();
}
