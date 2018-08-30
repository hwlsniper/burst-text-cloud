package com.burst.text.service.user.impl;

import com.burst.text.annotation.Log;
import com.burst.text.entity.TabUserToken;
import com.burst.text.excepte.BizException;
import com.burst.text.mapper.TabUserTokenMapper;
import com.burst.text.service.user.UserTokenService;
import com.burst.text.util.IdWorker;
import com.burst.text.util.TokenBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户 token service
 * @author Administrator
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    private static final Logger logger = LoggerFactory.getLogger(UserTokenServiceImpl.class);

    @Autowired
    private TabUserTokenMapper tokenMapper;

    public static final IdWorker idWork = new IdWorker();

    /**
     * 根据用户token 查询用户ID
     * @return
     */
    @Override
    public String queryUserIdForToken(){

        return null;
    }

    /**
     * 根据用户ID,获取 user token
     * @param userId
     * @return
     */
    @Override
    @Log(operationType="getUserToken操作",operationName="根据userId获取 user token")
    public String getUserToken(String userId) throws BizException {
        try{
            TabUserToken userToken = new TabUserToken();
            Map<String, Object> param = new HashMap();
            //判断用户 token 是否过期
            userToken = tokenMapper.queryUserToken(param);
            if(null != userToken){
                return userToken.getUserToken();
            }

            String token = getNextToken();
            userToken.setId(idWork.nextId()+"");
            userToken.setUserId(userId);
            userToken.setUserToken(token);
            tokenMapper.saveSelective(userToken);
            return token;
        }catch (Exception ex){
            logger.error("异常方法:{}异常信息:{}", UserTokenServiceImpl.class.getName()+".getUserToken", ex.getMessage());
            throw new BizException(400, "获取usertoken失败!");
        }
    }

    /**
     * 生成 user token
     * @return
     */
    private String getNextToken(){
        TokenBuilder.TokenCreator tokenCreator = TokenBuilder.uuidCreator;
        String token = tokenCreator.create();
        if(!StringUtils.isNotBlank(token) || token.length() < 28 || token.length() > 32){
            getNextToken();
        }
        return token;
    }
}
