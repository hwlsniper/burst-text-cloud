package com.burst.text.mapper;

import com.burst.text.model.SysDictionaryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDictionaryMapper {

    List<SysDictionaryBean> querySysDictList(Map<String, Object> param);
}
