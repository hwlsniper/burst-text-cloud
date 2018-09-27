package com.burst.text.web;

import com.burst.text.service.poster.PosterService;
import com.burst.text.util.MathUtil;
import com.burst.text.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 海报
 * @author Administrator
 */
@RestController
public class PosterController {

    @Autowired
    private PosterService posterService;

    /**
     * 获取海报类型
     * @param request
     * @return
     */
    @GetMapping("/poster/queryPosterType")
    public Result queryPosterType(HttpServletRequest request){
        Result result = Result.responseSuccess();
        result = posterService.queryPosterType();
        return result;
    }

    /**
     * 获取海报列表
     * @param request
     * @return
     */
    @GetMapping("/poster/queryPosterList")
    public Result queryPosterList(HttpServletRequest request, @RequestParam String posterType){
        Result result = Result.responseSuccess();
        Map<String, Object> param = new HashMap<>();
        param.put("posterType",posterType);
        int pageNum = MathUtil.toInt(request.getParameter("pageNum"), 1);
        int pageSize = MathUtil.toInt(request.getParameter("pageNum"), 20);
        result = posterService.queryPosterList(param, pageNum, pageSize);
        return result;
    }

    /**
     * 获取海报
     * @param posterId
     * @return
     */
    @GetMapping("/poster/queryPoster")
    public Result queryPoster(@RequestParam String posterId){
        Result result = Result.responseSuccess();
        Map<String, Object> param = new HashMap<>();
        result = posterService.queryPoster(param);
        return result;
    }

    /**
     * 编辑海报
     * 显示头像、电话、平台二维码
     * flag:1 表示的是获取平台的二维码  2：表示获取的是个人二维码
     * @param request
     * @return
     */
    @GetMapping("/poster/editPoster/{flag}")
    public Result editPoster(HttpServletRequest request, @PathVariable("flag") int flag){
        Result result = Result.responseSuccess();
        result = posterService.queryUserInfo(flag);
        return result;
    }
}
