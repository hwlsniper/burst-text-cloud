package com.burst.text.mapper;

import com.burst.text.dto.UserTokenBean;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.entity.TabUserInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
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

    TabUserInfo queryPlatformInfo();

    String queryPlatformQrCode();

    UserTokenBean queryUserInfoByWechat(Map<String, Object> param);
}