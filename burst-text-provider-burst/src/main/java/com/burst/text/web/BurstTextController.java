package com.burst.text.web;

import com.burst.text.service.burst.BurstTextService;
import com.burst.text.util.MathUtil;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 爆文
 *
 * @author Administrator
 */
@RestController
public class BurstTextController {

    @Autowired
    private BurstTextService burstTextService;

    /**
     * 查询爆文类型
     *
     * @param request
     * @return
     */
    @GetMapping("/burstText/queryBurstTextType")
    public Result queryBurstTextType(HttpServletRequest request) {
        Result result = Result.responseSuccess();
        String dataType = request.getParameter("dataType");
        if (null == dataType || "".equals(dataType)) {
            dataType = SysCommonConstant.BURST_TYPE;
        }
        result = burstTextService.queryBurstTextType(dataType);
        return result;
    }

    /**
     * 查询爆文列表
     *
     * @param request
     * @return
     */
    @GetMapping("/burstText/queryBurstTextList")
    public Result queryBurstTextList(HttpServletRequest request, String burstType) {
        Result result = Result.responseSuccess();
        Map<String, Object> param = new HashMap<>(2);
        param.put("burstType", burstType);
        int pageNum = MathUtil.toInt(request.getParameter("pageNum"), 1);
        int pageSize = MathUtil.toInt(request.getParameter("pageSize"), 20);
        result = burstTextService.queryBurstTextList(param, pageNum, pageSize);
        return result;
    }

    /**
     * 查询爆文详情
     *
     * @param burstId
     * @return
     */
    @GetMapping("/burstText/queryBurstText")
    public Result queryBurstText(String burstId) {
        Result result = Result.responseSuccess();
        result = burstTextService.queryBurstText(burstId);
        return result;
    }

    /**
     * 创建爆文
     *
     * @param request
     * @return
     */
    public Result createBurstText(HttpServletRequest request, @RequestParam String pageUrl) {
        Result result = Result.responseSuccess();

        return result;
    }
}
