package com.burst.text.mapper;

import com.burst.text.entity.TabCourseInfo;
import com.burst.text.entity.TabSysDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TabCourseInfoMapper {

    List<TabSysDictionary> queryCourseType();

    List<TabCourseInfo> queryCourseWareList(Map<String, Object> param);

    TabCourseInfo queryCourseWare(Map<String, Object> param);

    int saveCourseWare(TabCourseInfo courseInfo);
}
