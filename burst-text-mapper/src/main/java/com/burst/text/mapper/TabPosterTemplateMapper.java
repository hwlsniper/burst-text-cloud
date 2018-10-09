package com.burst.text.mapper;

import com.burst.text.dto.PosterTypeBean;
import com.burst.text.entity.TabPosterTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TabPosterTemplateMapper {

    List<PosterTypeBean> queryPosterType();

    List<TabPosterTemplate> queryPosterTempList(Map<String, Object> param);

    Map<String, String> queryPosterInfo(Map<String, Object> param);
}
