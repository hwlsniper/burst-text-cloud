package com.burst.text.web;

import com.burst.text.service.user.UserService;
import com.burst.text.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户 controller
 * @author Administrator
 */
@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户微信授权
     * @param request
     * @param response
     * @return
     */
    @PostMapping("authorizeUser")
    public Result authorizeUser(HttpServletRequest request, HttpServletResponse response){
        Result result = Result.responseSuccess();
        result = userService.authorizeUser(request, response);
        return result;
    }

    /**
     * 获取用户信息
     * @return
     */
    @PostMapping("queryUser")
    @ResponseBody
    public Result queryUser(){
        Result result = Result.responseSuccess();
        result = userService.queryUser();
        return result;
    }
}
