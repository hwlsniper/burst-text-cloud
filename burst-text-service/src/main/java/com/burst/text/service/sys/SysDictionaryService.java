package com.burst.text.service.sys;

import com.burst.text.util.Result;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * 字典数据 service
 */
@Service
public interface SysDictionaryService {

    /**
     * 根据字典数据类型 查询字典表数据
     *
     * @param dataType
     * @return
     */
    Result querySysDictionary(String dataType);
}
