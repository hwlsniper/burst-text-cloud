package com.burst.text.web;

import com.burst.text.entity.TabUserInfo;
import com.burst.text.service.user.UserService;
import com.burst.text.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户 controller
 *
 * @author Administrator
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/user/queryUser")
    public Result queryUser() {
        Result result = Result.responseSuccess();
        result = userService.queryUser();
        return result;
    }

    /**
     * 修改用户信息
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/user/modifyUser")
    public Result modifyUserInfo(HttpServletRequest request, HttpServletResponse response, TabUserInfo userInfo) {
        Result result = Result.responseSuccess();
        if (null != userInfo && StringUtils.isNotBlank(userInfo.getNickName())) {
            result.setCode(400);
            result.setMsg("请填写昵称!");
            return result;
        }
        result = userService.modifyUserInfo(userInfo);
        return result;
    }

}
