package com.burst.text.service.sys.impl;

import com.burst.text.annotation.Log;
import com.burst.text.entity.TabSysDictionary;
import com.burst.text.entity.TabSysDictionaryExample;
import com.burst.text.mapper.TabSysDictionaryMapper;
import com.burst.text.service.sys.SysDictionaryService;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysDictionaryServiceImpl implements SysDictionaryService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictionaryServiceImpl.class);

    @Autowired
    private TabSysDictionaryMapper sysDictionaryMapper;

    /**
     * 根据字典数据类型 查询字典表数据
     * @param dataType
     * @return
     */
    @Override
    @Log(operationType="querySysDictionary操作",operationName="查询字典数据")
    public Result querySysDictionary(String dataType){
        Result result = Result.responseSuccess();
        try{
            TabSysDictionaryExample example = new TabSysDictionaryExample();
            TabSysDictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andDataTypeEqualTo(dataType);
            criteria.andIsEnableEqualTo(SysCommonConstant.DEFAULT_COMMON_ONE);
            List<TabSysDictionary> lists = sysDictionaryMapper.selectByExample(example);
            result.setData(lists);
        }catch(Exception ex){
            logger.error("异常方法:{}异常信息:{}", SysDictionaryServiceImpl.class.getName()+".querySysDictionary", ex.getMessage());
            result.setCode(400);
            result.setMsg("查询字典数据失败!");
        }
        return result;
    }
}
