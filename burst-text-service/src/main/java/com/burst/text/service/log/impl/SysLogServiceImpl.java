package com.burst.text.service.log.impl;

import com.burst.text.entity.TabSysLog;
import com.burst.text.mapper.TabSysLogMapper;
import com.burst.text.service.log.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统日志 service
 * @author Administrator
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private TabSysLogMapper sysLogMapper;

    @Override
    public int saveSysLog(TabSysLog sysLog){

        return 0;
    }
}
