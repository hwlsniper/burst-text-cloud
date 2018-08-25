package com.burst.text.service.user;

import com.burst.text.entity.TabUserInfo;
import com.burst.text.entity.TabUserInfoExample;
import com.burst.text.util.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户 service
 */
@Service
public interface UserService {

    /**
     * 微信授权获取用户信息,并保存
     * @param request
     * @param response
     * @return
     */
    Result authorizeUser(HttpServletRequest request, HttpServletResponse response);

    /**
     * 保存 用户信息
     * @param userInfo
     * @return
     */
    Result saveUser(TabUserInfo userInfo);

    /**
     * 获取 用户信息
     * @param example
     * @return
     */
    Result queryUser(TabUserInfoExample example);

    /**
     * 获取 用户信息
     * @return
     */
    Result queryUser();

    /**
     * 通过微信的 unionid 获取用户信息
     * @param unionid
     * @return
     */
    TabUserInfo queryUserInfo(String unionid);
}
