package com.burst.text.service.impl;

import com.burst.text.common.CommonStaticConstant;
import com.burst.text.mapper.BurstTextMapper;
import com.burst.text.model.BurstTextBean;
import com.burst.text.model.BurstTextInfo;
import com.burst.text.service.BurstTextService;
import com.burst.text.util.IdWorker;
import com.burst.text.util.ImageUrlUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BurstTextServiceImpl implements BurstTextService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BurstTextServiceImpl.class);

    @Autowired
    private BurstTextMapper burstTextMapper;

    @Override
    public PageInfo<BurstTextBean> queryBurstList(Map<String, Object> param, int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<BurstTextBean> bursts = burstTextMapper.queryBurstList(param);
            PageInfo<BurstTextBean> pages = new PageInfo<>(bursts);
            return pages;
        } catch (Exception ex) {
            LOGGER.error("异常方法:{},异常信息:{}", BurstTextServiceImpl.class.getName() + ".queryBurstList", ex.getMessage());
        }
        return null;
    }

    @Override
    public BurstTextInfo queryBurstText(String burstId) {
        Map<String, Object> param = new HashMap<>();
        param.put("burstId", burstId);
        BurstTextInfo burstText = burstTextMapper.queryBurstText(param);
        if (null == burstText) {
            burstText = new BurstTextInfo();
        }
        if (null != burstText && StringUtils.isNotBlank(burstText.getTitleImg())) {
            List<String> list = new ArrayList<>(Arrays.asList(burstText.getTitleImg().split(",")));
            List<String> imgs = new ArrayList<>();
            if (null != list && list.size() > 0) {
                for (String img : list) {
                    imgs.add(ImageUrlUtil.getThumbnailUrl(img));
                }
            }
            burstText.setTitleImgs(imgs);
        }
        return burstText;
    }

    @Override
    public void saveBurstText(BurstTextInfo burstInfo) throws Exception {
        try {
            if (null != burstInfo && StringUtils.isNotBlank(burstInfo.getBurstId())) {
                burstTextMapper.updateBurstText(burstInfo);
                return;
            }
            burstInfo.setUserId("106331420484902912");
            IdWorker idWorker = new IdWorker();
            burstInfo.setBurstId(idWorker.nextId());
            burstTextMapper.saveBurstText(burstInfo);
        } catch (Exception e) {
            LOGGER.error("异常方法:{},异常信息:{}", BurstTextServiceImpl.class.getName() + ".saveBurstText", e.getMessage());
            throw new Exception("保存失败!");
        }
    }

    @Override
    public void releaseTop(String burstId, Integer mark, String editType) throws Exception {
        try {
            BurstTextInfo burstInfo = new BurstTextInfo();
            burstInfo.setBurstId(burstId);
            if (CommonStaticConstant.BURST_EDIT_IS_TOP.equals(editType)) {
                burstInfo.setIsTop(mark);
            }
            if (CommonStaticConstant.BURST_EDIT_IS_ENABLE.equals(editType)) {
                burstInfo.setIsEnable(mark);
            }
            burstTextMapper.updateBurstText(burstInfo);
        } catch (Exception ex) {
            LOGGER.error("异常方法:{},异常信息:{}", BurstTextServiceImpl.class.getName() + ".releaseTop", ex.getMessage());
            throw new Exception("修改失败!");
        }
    }
}
