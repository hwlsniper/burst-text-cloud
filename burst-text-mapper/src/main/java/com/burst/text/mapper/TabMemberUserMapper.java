package com.burst.text.mapper;

import com.burst.text.entity.TabMemberUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TabMemberUserMapper {

    TabMemberUser queryMemberUser(Map<String, Object> param);
}
