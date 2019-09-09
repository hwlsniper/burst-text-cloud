package com.burst.text.service;

import com.burst.text.model.AdminUserBean;
import com.burst.text.model.Menu;

import java.util.List;

/**
 * 登录 service
 */
public interface UserService {

    AdminUserBean queryAdminUser(String userName, String passWord);

    List<Menu> getMenuList();
}
