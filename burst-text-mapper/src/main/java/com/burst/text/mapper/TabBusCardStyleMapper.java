package com.burst.text.mapper;

import com.burst.text.entity.TabBusCardStyle;
import com.burst.text.entity.TabBusCardStyleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabBusCardStyleMapper {
    long countByExample(TabBusCardStyleExample example);

    int deleteByExample(TabBusCardStyleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabBusCardStyle record);

    int insertSelective(TabBusCardStyle record);

    List<TabBusCardStyle> selectByExample(TabBusCardStyleExample example);

    TabBusCardStyle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabBusCardStyle record, @Param("example") TabBusCardStyleExample example);

    int updateByExample(@Param("record") TabBusCardStyle record, @Param("example") TabBusCardStyleExample example);

    int updateByPrimaryKeySelective(TabBusCardStyle record);

    int updateByPrimaryKey(TabBusCardStyle record);
}