package com.burst.text.mapper;

import com.burst.text.entity.TabSysLog;
import com.burst.text.entity.TabSysLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TabSysLogMapper {
    long countByExample(TabSysLogExample example);

    int deleteByExample(TabSysLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabSysLog record);

    int insertSelective(TabSysLog record);

    List<TabSysLog> selectByExample(TabSysLogExample example);

    TabSysLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabSysLog record, @Param("example") TabSysLogExample example);

    int updateByExample(@Param("record") TabSysLog record, @Param("example") TabSysLogExample example);

    int updateByPrimaryKeySelective(TabSysLog record);

    int updateByPrimaryKey(TabSysLog record);
}