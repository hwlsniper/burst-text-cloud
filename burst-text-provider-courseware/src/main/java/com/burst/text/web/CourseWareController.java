package com.burst.text.web;

import com.burst.text.service.course.CourseWareService;
import com.burst.text.util.MathUtil;
import com.burst.text.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseWareController {

    @Autowired
    private CourseWareService courseWareService;

    /**
     * 获取课件类型
     * @return
     */
    @GetMapping("/courseware/courseType")
    public Result queryCourseType(){
        Result result = Result.responseSuccess();
        result = courseWareService.queryCourseType();
        return result;
    }

    /**
     * 获取课件列表
     * @param request
     * @param courseType
     * @return
     */
    @GetMapping("/courseware/queryCourseList")
    public Result queryCourseWareList(HttpServletRequest request, @RequestParam String courseType){
        Result result = Result.responseSuccess();
        Map<String, Object> param = new HashMap<>();
        param.put("courseType", courseType);
        int pageNum = MathUtil.toInt(request.getParameter("pageNum"), 1);
        int pageSize = MathUtil.toInt(request.getParameter("pageNum"), 20);
        result = courseWareService.queryCourseWareList(param, pageNum, pageSize);
        return result;
    }

    /**
     * 获取课件详情
     * @param request
     * @param courseId
     * @return
     */
    @GetMapping("/courseware/queryCourseWare")
    public Result queryCourseWare(HttpServletRequest request, @RequestParam String courseId){
        Result result = Result.responseSuccess();
        result = courseWareService.queryCourseWare(courseId);
        return result;
    }
}
