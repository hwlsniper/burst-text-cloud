package com.burst.text.web;

import com.burst.text.model.AdminUserBean;
import com.burst.text.model.Menu;
import com.burst.text.model.MenuTree;
import com.burst.text.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 登录、退出
 */
@Controller
@RequestMapping("console/")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登录页登录
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "/console/login";
    }

    @PostMapping("index")
    public String index(String username, String password, Model model) {
        //获取用户信息,没有用户信息,跳转到登录页;有用户信息,执行 index 方法
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return "console/login";
        }
        AdminUserBean adminUser = userService.queryAdminUser(username, password);
        if (null == adminUser) {
            return "console/login";
        }
        List<Menu> menuLists = userService.getMenuList();
        MenuTree menuTreeUtil = new MenuTree(menuLists, null);
        model.addAttribute("admin", adminUser);
        model.addAttribute("menuLists", menuTreeUtil.buildTreeGrid());
        return "console/index";
    }

    @GetMapping("main")
    public String main() {

        return "/console/right";
    }

    /**
     * 退出
     *
     * @return
     */
    @GetMapping("logout")
    public String logout() {

        return "console/login";
    }
}