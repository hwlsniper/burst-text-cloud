package com.burst.text.service.impl;

import com.burst.text.mapper.AdminUserMapper;
import com.burst.text.model.AdminUserBean;
import com.burst.text.model.Menu;
import com.burst.text.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * 查询用户信息
     *
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public AdminUserBean queryAdminUser(String userName, String passWord) {
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("userName", userName);
            param.put("passWord", passWord);
            return adminUserMapper.queryAdminUser(param);
        } catch (Exception ex) {
            LOGGER.error("异常方法:{},异常信息:{}", UserServiceImpl.class.getName() + ".queryAdminUser", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Menu> getMenuList() {
        List<Menu> menus = new ArrayList<>();

        Menu menu = new Menu();
        menu.setMenuId("3ac96215e82f40b5bfe442e6828641df");
        menu.setMenuName("系统管理");
        menu.setMenuType("menu");
        menu.setMenuUrl("");
        menu.setMenuCode("system:admin");
        menu.setParentId("0");
        menus.add(menu);

        menu = new Menu();
        menu.setMenuId("6580896645d046a0acf3c1194d7bbf8e");
        menu.setMenuName("爆文管理");
        menu.setMenuType("menu");
        menu.setMenuUrl("/console/burst/index");
        menu.setMenuCode("admin:delete");
        menu.setParentId("3ac96215e82f40b5bfe442e6828641df");
        menus.add(menu);

        menu = new Menu();
        menu.setMenuId("984909260a06410d9be37c300e3df09d");
        menu.setMenuName("会员管理");
        menu.setMenuType("menu");
        menu.setMenuUrl("/console/member/index");
        menu.setMenuCode("member:default");
        menu.setParentId("3ac96215e82f40b5bfe442e6828641df");
        menus.add(menu);

        menu = new Menu();
        menu.setMenuId("aab7966c97db4643a36cb5afa24be38b");
        menu.setMenuName("海报管理");
        menu.setMenuType("menu");
        menu.setMenuUrl("/console/poster/index");
        menu.setMenuCode("role:delete");
        menu.setParentId("3ac96215e82f40b5bfe442e6828641df");
        menus.add(menu);

        return menus;
    }
}
