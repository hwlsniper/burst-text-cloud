package com.burst.text.mapper;

import com.burst.text.entity.TabSysDataType;
import com.burst.text.entity.TabSysDataTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TabSysDataTypeMapper {
    long countByExample(TabSysDataTypeExample example);

    int deleteByExample(TabSysDataTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabSysDataType record);

    int insertSelective(TabSysDataType record);

    List<TabSysDataType> selectByExample(TabSysDataTypeExample example);

    TabSysDataType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabSysDataType record, @Param("example") TabSysDataTypeExample example);

    int updateByExample(@Param("record") TabSysDataType record, @Param("example") TabSysDataTypeExample example);

    int updateByPrimaryKeySelective(TabSysDataType record);

    int updateByPrimaryKey(TabSysDataType record);
}