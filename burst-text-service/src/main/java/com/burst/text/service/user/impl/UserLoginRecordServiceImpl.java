package com.burst.text.service.user.impl;

import com.burst.text.annotation.Log;
import com.burst.text.entity.TabUserLoginRecord;
import com.burst.text.excepte.BizException;
import com.burst.text.mapper.TabUserLoginRecordMapper;
import com.burst.text.service.user.UserLoginRecordService;
import com.burst.text.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * 用户登录记录
 */
@Service
public class UserLoginRecordServiceImpl implements UserLoginRecordService {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginRecordServiceImpl.class);

    public static final IdWorker idWork = new IdWorker();

    @Autowired
    private TabUserLoginRecordMapper loginRecordMapper;

    /**
     * 保存用户登录记录
     *
     * @param userId
     * @return
     */
    @Override
    @Log(operationType = "saveUserLoginRecord操作", operationName = "保存用户登录记录")
    public void saveUserLoginRecord(String userId) throws BizException {
        try {
            TabUserLoginRecord record = new TabUserLoginRecord();
            record.setId(idWork.nextId() + "");
            record.setUserId(userId);
            loginRecordMapper.insertSelective(record);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", UserLoginRecordServiceImpl.class.getName() + ".saveUserLoginRecord", ex.getMessage());
            throw new BizException(400, "保存用户登录记录失败!");
        }
    }
}
