package com.burst.text.mapper;

import com.burst.text.dto.CourseTypeBean;
import com.burst.text.entity.TabCourseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TabCourseInfoMapper {

    List<CourseTypeBean> queryCourseType();

    List<TabCourseInfo> queryCourseWareList(Map<String, Object> param);

    String queryCourseWare(Map<String, Object> param);
}
