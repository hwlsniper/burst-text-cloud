package com.burst.text.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 海报
 */
@Controller
@RequestMapping("console/poster/")
public class PosterController {

    @GetMapping("index")
    public String index() {

        return "console/poster/index";
    }
}
