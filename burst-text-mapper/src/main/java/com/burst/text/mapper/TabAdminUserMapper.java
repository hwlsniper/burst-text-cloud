package com.burst.text.mapper;

import com.burst.text.entity.TabAdminUser;
import com.burst.text.entity.TabAdminUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TabAdminUserMapper {
    long countByExample(TabAdminUserExample example);

    int deleteByExample(TabAdminUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabAdminUser record);

    int insertSelective(TabAdminUser record);

    List<TabAdminUser> selectByExample(TabAdminUserExample example);

    TabAdminUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabAdminUser record, @Param("example") TabAdminUserExample example);

    int updateByExample(@Param("record") TabAdminUser record, @Param("example") TabAdminUserExample example);

    int updateByPrimaryKeySelective(TabAdminUser record);

    int updateByPrimaryKey(TabAdminUser record);
}