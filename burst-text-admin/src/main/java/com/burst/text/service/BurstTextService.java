package com.burst.text.service;

import com.burst.text.model.BurstTextBean;
import com.burst.text.model.BurstTextInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 爆文 service
 */
@Service
public interface BurstTextService {

    PageInfo<BurstTextBean> queryBurstList(Map<String, Object> param, int pageNo, int pageSize);

    BurstTextInfo queryBurstText(String burstId);

    void saveBurstText(BurstTextInfo burstInfo) throws Exception;

    void releaseTop(String burstId, Integer mark, String editType) throws Exception;
}
