package com.burst.text.service.user;

import com.burst.text.entity.TabUserToken;
import org.springframework.stereotype.Service;

/**
 * 用户 token service
 * @author Administrator
 */
@Service
public interface UserTokenService {

    /**
     * 根据用户token 查询用户ID
     * @return
     */
    String queryUserIdForToken();

    /**
     * 根据用户ID,获取 user token
     * @param userId
     * @return
     */
    String getUserToken(String userId);
}
