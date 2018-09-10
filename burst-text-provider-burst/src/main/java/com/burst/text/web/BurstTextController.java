package com.burst.text.web;

import com.burst.text.service.burst.BurstTextService;
import com.burst.text.util.MathUtil;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class BurstTextController {

    @Autowired
    private BurstTextService burstTextService;

    /**
     * 查询爆文类型
     * @param request
     * @return
     */
    @PostMapping("/burstText/querySysDictionary")
    public Result querySysDictionary(HttpServletRequest request){
        Result result = Result.responseSuccess();
        String dataType = request.getParameter("dataType");
        if(null == dataType || "".equals(dataType)){
            dataType = SysCommonConstant.BURST_TYPE;
        }
        result = burstTextService.querySysDictionaryList(dataType);
        return result;
    }

    /**
     * 查询爆文列表
     * @param request
     * @return
     */
    @PostMapping("/burstText/queryBurstText")
    public Result queryBurstText(HttpServletRequest request){
        Result result = Result.responseSuccess();
        Map<String, Object> param = new HashMap<>(2);
        int pageNum = MathUtil.toInt(request.getParameter("pageNum"), 1);
        int pageSize = MathUtil.toInt(request.getParameter("pageNum"), 20);
        result = burstTextService.queryBurstText(param, pageNum, pageSize);
        return result;
    }

    /**
     * 创建爆文
     * @param request
     * @return
     */
    public Result createBurstText(HttpServletRequest request, @RequestParam(required = true) String pageUrl){
        Result result = Result.responseSuccess();

        return result;
    }
}
