package com.burst.text.mapper;

import com.burst.text.model.AdminUserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AdminUserMapper {
    AdminUserBean queryAdminUser(Map<String, Object> param);
}
