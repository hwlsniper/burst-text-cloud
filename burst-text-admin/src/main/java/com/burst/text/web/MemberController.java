package com.burst.text.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户、会员
 */
@Controller
@RequestMapping("console/member/")
public class MemberController {

    @GetMapping("index")
    public String index() {

        return "console/member/index";
    }
}
