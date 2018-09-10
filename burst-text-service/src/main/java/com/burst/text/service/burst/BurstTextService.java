package com.burst.text.service.burst;

import com.burst.text.util.Result;

import java.util.Map;

/**
 * @author Administrator
 * 新闻 service
 */
public interface BurstTextService {

    Result saveBurstText();

    /**
     * 查询 新闻 list
     * @param param
     * @return
     */
    Result queryBurstText(Map<String, Object> param, int pageNum, int pageSize);

    /**
     * 查询 爆文分类
     * @param dataType
     * @return
     */
    Result querySysDictionaryList(String dataType);
}
