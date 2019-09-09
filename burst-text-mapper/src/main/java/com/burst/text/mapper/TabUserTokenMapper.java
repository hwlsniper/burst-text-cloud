package com.burst.text.mapper;

import com.burst.text.entity.TabUserToken;
import com.burst.text.entity.TabUserTokenExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TabUserTokenMapper {
    long countByExample(TabUserTokenExample example);

    int deleteByExample(TabUserTokenExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabUserToken record);

    int insertSelective(TabUserToken record);

    List<TabUserToken> selectByExample(TabUserTokenExample example);

    TabUserToken selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabUserToken record, @Param("example") TabUserTokenExample example);

    int updateByExample(@Param("record") TabUserToken record, @Param("example") TabUserTokenExample example);

    int updateByPrimaryKeySelective(TabUserToken record);

    int updateByPrimaryKey(TabUserToken record);

    TabUserToken queryUserToken(Map<String, Object> param);

    int saveSelective(TabUserToken record);

    String queryUserIdForToken(@Param("userToken") String userToken);
}