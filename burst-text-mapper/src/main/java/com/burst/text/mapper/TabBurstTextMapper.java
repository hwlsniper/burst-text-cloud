package com.burst.text.mapper;

import com.burst.text.entity.TabBurstText;
import com.burst.text.entity.TabBurstTextExample;
import com.burst.text.entity.TabSysDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TabBurstTextMapper {
    long countByExample(TabBurstTextExample example);

    int deleteByExample(TabBurstTextExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabBurstText record);

    int insertSelective(TabBurstText record);

    List<TabBurstText> selectByExample(TabBurstTextExample example);

    TabBurstText selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabBurstText record, @Param("example") TabBurstTextExample example);

    int updateByExample(@Param("record") TabBurstText record, @Param("example") TabBurstTextExample example);

    int updateByPrimaryKeySelective(TabBurstText record);

    int updateByPrimaryKey(TabBurstText record);

    List<TabBurstText> queryBurstTextList(Map<String, Object> param);

    List<TabSysDictionary> queryBurstTextType(Map<String, Object> param);

    TabBurstText queryBurstText(@Param("burstId") String burstId);
}