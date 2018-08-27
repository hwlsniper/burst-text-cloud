package com.burst.text.service.burst.impl;

import com.burst.text.annotation.Log;
import com.burst.text.entity.TabBurstText;
import com.burst.text.entity.TabSysDictionary;
import com.burst.text.mapper.TabBurstTextMapper;
import com.burst.text.service.burst.BurstTextService;
import com.burst.text.util.Result;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * 新闻 service
 */
public class BurstTextServiceImpl implements BurstTextService {

    private static final Logger logger = LoggerFactory.getLogger(BurstTextServiceImpl.class);

    @Autowired
    private TabBurstTextMapper burstTextMapper;

    @Override
    public Result saveBurstText() {
        return null;
    }

    /**
     * 查询 新闻 list
     * @param param
     * @return
     */
    @Override
    @Log(operationType="queryBurstText操作",operationName="查询爆文列表数据")
    public Result queryBurstText(Map<String, Object> param, int pageNum, int pageSize) {
        Result result = Result.responseSuccess();
        try{
            List<TabBurstText> burstTexts = new ArrayList<>();
            PageHelper.startPage(pageNum, pageSize);
            burstTexts = burstTextMapper.queryBurstText(param);
            result.setData(burstTexts);
        }catch (Exception ex){
            logger.error("异常方法:{}异常信息:{}", BurstTextServiceImpl.class.getName()+".queryBurstText", ex.getMessage());
            result.setCode(400);
            result.setMsg("查询爆文列表数据失败!");
        }
        return result;
    }

    @Override
    @Log(operationType="querySysDictionaryList操作",operationName="查询字典数据")
    public Result querySysDictionaryList(String dataType){
        Result result = Result.responseSuccess();
        try{
            Map<String, Object> param = new HashMap<>();
            param.put("dataType",dataType);
            List<TabSysDictionary> lists = burstTextMapper.querySysDictionary(param);
            result.setData(lists);
        }catch(Exception ex){
            logger.error("异常方法:{}异常信息:{}", BurstTextServiceImpl.class.getName()+".querySysDictionaryList", ex.getMessage());
            result.setCode(400);
            result.setMsg("查询字典数据失败!");
        }
        return result;
    }
}
