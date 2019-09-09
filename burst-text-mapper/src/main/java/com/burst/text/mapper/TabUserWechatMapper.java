package com.burst.text.mapper;

import com.burst.text.entity.TabUserWechat;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TabUserWechatMapper {

    int saveUserWechat(TabUserWechat userWechat);
}
