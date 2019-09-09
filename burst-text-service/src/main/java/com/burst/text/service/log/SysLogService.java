package com.burst.text.service.log;

import com.burst.text.entity.TabSysLog;
import org.springframework.stereotype.Service;

/**
 * 系统日志 service
 *
 * @author Administrator
 */
@Service
public interface SysLogService {

    /**
     * 保存日志
     *
     * @param sysLog
     * @return
     */
    public int saveSysLog(TabSysLog sysLog);
}
