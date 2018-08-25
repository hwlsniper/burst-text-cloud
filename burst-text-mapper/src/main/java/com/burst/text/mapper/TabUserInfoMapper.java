package com.burst.text.mapper;

import com.burst.text.entity.TabUserInfo;
import com.burst.text.entity.TabUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabUserInfoMapper {
    long countByExample(TabUserInfoExample example);

    int deleteByExample(TabUserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabUserInfo record);

    int insertSelective(TabUserInfo record);

    List<TabUserInfo> selectByExample(TabUserInfoExample example);

    TabUserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabUserInfo record, @Param("example") TabUserInfoExample example);

    int updateByExample(@Param("record") TabUserInfo record, @Param("example") TabUserInfoExample example);

    int updateByPrimaryKeySelective(TabUserInfo record);

    int updateByPrimaryKey(TabUserInfo record);
}