package com.burst.text.mapper;

import com.burst.text.entity.TabBurstCard;
import com.burst.text.entity.TabBurstCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabBurstCardMapper {
    long countByExample(TabBurstCardExample example);

    int deleteByExample(TabBurstCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabBurstCard record);

    int insertSelective(TabBurstCard record);

    List<TabBurstCard> selectByExample(TabBurstCardExample example);

    TabBurstCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabBurstCard record, @Param("example") TabBurstCardExample example);

    int updateByExample(@Param("record") TabBurstCard record, @Param("example") TabBurstCardExample example);

    int updateByPrimaryKeySelective(TabBurstCard record);

    int updateByPrimaryKey(TabBurstCard record);
}