package com.burst.text.web;

import com.burst.text.service.user.UserService;
import com.burst.text.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class WxAuthController {

    @Autowired
    private UserService userService;

    /**
     * 用户微信授权
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/user/authorizeUser")
    public String authorizeUser(HttpServletRequest request, HttpServletResponse response) {
        Result result = Result.responseSuccess();
        result = userService.authorizeUser(request, response);
        return "redirect:http://www.baidu.com?uset_token=" + result.getData();
    }

    /**
     * 分享
     *
     * @param dataMap
     * @param request
     * @param response
     */
    @GetMapping("/weChat/getShareWXTicket")
    public void getShareWXTicket(@RequestBody Map<String, String> dataMap,
                                 HttpServletRequest request, HttpServletResponse response) {

    }
}
