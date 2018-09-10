package com.burst.text.mapper;

import com.burst.text.entity.TabSysDictionary;
import com.burst.text.entity.TabSysDictionaryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface TabSysDictionaryMapper {
    long countByExample(TabSysDictionaryExample example);

    int deleteByExample(TabSysDictionaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabSysDictionary record);

    int insertSelective(TabSysDictionary record);

    List<TabSysDictionary> selectByExample(TabSysDictionaryExample example);

    TabSysDictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabSysDictionary record, @Param("example") TabSysDictionaryExample example);

    int updateByExample(@Param("record") TabSysDictionary record, @Param("example") TabSysDictionaryExample example);

    int updateByPrimaryKeySelective(TabSysDictionary record);

    int updateByPrimaryKey(TabSysDictionary record);

    List<TabSysDictionary> querySysDictionaryList(Map<String, Object> param);
}