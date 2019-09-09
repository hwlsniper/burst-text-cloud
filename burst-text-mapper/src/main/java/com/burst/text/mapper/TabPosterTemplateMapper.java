package com.burst.text.mapper;

import com.burst.text.entity.TabPosterTemplate;
import com.burst.text.entity.TabSysDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TabPosterTemplateMapper {

    List<TabSysDictionary> queryPosterType();

    List<TabPosterTemplate> queryPosterTempList(Map<String, Object> param);

    Map<String, String> queryPosterInfo(Map<String, Object> param);

    int savePoster(TabPosterTemplate poster);
}
