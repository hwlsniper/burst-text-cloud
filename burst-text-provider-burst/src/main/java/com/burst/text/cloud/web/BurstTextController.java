package com.burst.text.cloud.web;

import com.burst.text.service.burst.BurstTextService;
import com.burst.text.util.MathUtil;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("burstText/")
public class BurstTextController {

    @Autowired
    private BurstTextService burstTextService;

    /**
     * 查询爆文类型
     * @param request
     * @return
     */
    @PostMapping("querySysDictionary")
    public Result querySysDictionary(HttpServletRequest request){
        Result result = Result.responseSuccess();
        String dataType = request.getParameter("dataType");
        if(null == dataType || "".equals(dataType)){
            dataType = SysCommonConstant.BURST_TYPE;
        }
        result = burstTextService.querySysDictionaryList(dataType);
        return result;
    }

    @PostMapping("queryBurstText")
    public Result queryBurstText(HttpServletRequest request){
        Result result = Result.responseSuccess();
        Map<String, Object> param = new HashMap<>();
        int pageNum = MathUtil.toInt(request.getParameter("pageNum"), 1);
        int pageSize = MathUtil.toInt(request.getParameter("pageNum"), 20);
        burstTextService.queryBurstText(param, pageNum, pageSize);
        return result;
    }
}
