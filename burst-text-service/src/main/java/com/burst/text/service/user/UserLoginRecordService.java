package com.burst.text.service.user;

import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * 用户登录记录
 */
@Service
public interface UserLoginRecordService {

    /**
     * 保存用户登录记录
     *
     * @param userId
     * @return
     */
    void saveUserLoginRecord(String userId);
}
