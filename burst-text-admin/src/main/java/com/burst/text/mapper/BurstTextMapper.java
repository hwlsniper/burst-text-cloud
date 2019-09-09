package com.burst.text.mapper;

import com.burst.text.model.BurstTextBean;
import com.burst.text.model.BurstTextInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BurstTextMapper {

    List<BurstTextBean> queryBurstList(Map<String, Object> param);

    BurstTextInfo queryBurstText(Map<String, Object> param);

    int saveBurstText(BurstTextInfo burstInfo);

    int updateBurstText(BurstTextInfo burstInfo);

}
