package com.burst.text.service.course;

import com.burst.text.util.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 课件 service
 */
@Service
public interface CourseWareService {

    /**
     * 获取 课件类型(分类)
     * @return
     */
    Result queryCourseType();

    /**
     * 获取 课件列表数据
     * @param param
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result queryCourseWareList(Map<String, Object> param, int pageNum, int pageSize);

    /**
     * 获取 课件详情
     * @param courseId
     * @return
     */
    Result queryCourseWare(String courseId);
}
