package com.burst.text.service.impl;

import com.burst.text.mapper.SysDictionaryMapper;
import com.burst.text.model.SysDictionaryBean;
import com.burst.text.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    @Override
    public List<SysDictionaryBean> querySysDictList(String dataType) {
        Map<String, Object> param = new HashMap<>();
        param.put("dataType", dataType);
        return sysDictionaryMapper.querySysDictList(param);
    }
}
