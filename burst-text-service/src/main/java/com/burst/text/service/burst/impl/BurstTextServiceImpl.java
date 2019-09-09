package com.burst.text.service.burst.impl;

import com.burst.text.annotation.Log;
import com.burst.text.entity.TabBurstText;
import com.burst.text.entity.TabSysDictionary;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.mapper.TabBurstTextMapper;
import com.burst.text.page.BTPage;
import com.burst.text.service.burst.BurstTextService;
import com.burst.text.service.user.UserService;
import com.burst.text.util.ImageUrlUtil;
import com.burst.text.util.Result;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * 新闻 service
 */
@Service
public class BurstTextServiceImpl implements BurstTextService {

    private static final Logger logger = LoggerFactory.getLogger(BurstTextServiceImpl.class);

    @Autowired
    private TabBurstTextMapper burstTextMapper;

    @Autowired
    private UserService userService;

    @Override
    public Result saveBurstText() {
        return null;
    }

    /**
     * 爆文类型
     *
     * @param dataType
     * @return
     */
    @Override
    @Log(operationType = "queryBurstTextType操作", operationName = "查询爆文类型")
    public Result queryBurstTextType(String dataType) {
        Result result = Result.responseSuccess();
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("dataType", dataType);
            List<TabSysDictionary> list = burstTextMapper.queryBurstTextType(param);
            result.setData(list);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", BurstTextServiceImpl.class.getName() + ".queryBurstTextType", ex.getMessage());
            result.setCode(400);
            result.setMsg("查询字典数据失败!");
        }
        return result;
    }

    /**
     * 查询 爆文 list
     *
     * @param param
     * @return
     */
    @Override
    @Log(operationType = "queryBurstTextList操作", operationName = "查询爆文列表数据")
    public Result queryBurstTextList(Map<String, Object> param, int pageNum, int pageSize) {
        Result result = Result.responseSuccess();
        try {
            List<TabBurstText> burstTexts = new ArrayList<>();
            PageHelper.startPage(pageNum, pageSize);
            burstTexts = burstTextMapper.queryBurstTextList(param);
            if (!CollectionUtils.isEmpty(burstTexts)) {
                List<String> imgs = null;
                for (TabBurstText burstText : burstTexts) {
                    imgs = new ArrayList<>();
                    if (null != burstText && StringUtils.isNotBlank(burstText.getTitleImg())) {
                        String[] strs = burstText.getTitleImg().split(",");
                        for (String img : strs) {
                            imgs.add(ImageUrlUtil.getThumbnailUrl(img));
                        }
                    }
                    burstText.setTitleImgs(StringUtils.join(imgs, ","));
                }
            }
            BTPage<TabBurstText> pages = new BTPage<>(burstTexts);
            result.setData(pages);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", BurstTextServiceImpl.class.getName() + ".queryBurstTextList", ex.getMessage());
            result.setCode(400);
            result.setMsg("查询爆文列表数据失败!");
        }
        return result;
    }

    /**
     * 爆文详情
     *
     * @param burstId
     * @return
     */
    @Override
    public Result queryBurstText(String burstId) {
        Result result = Result.responseSuccess();
        try {
            TabBurstText burstText = this.queryBurstTextInfo(burstId);
            TabUserInfo userInfo = userService.getUserInfo();
            Map<String, Object> map = new HashMap<>();
            map.put("userInfo", userInfo);
            map.put("burstText", burstText);
            result.setData(map);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", BurstTextServiceImpl.class.getName() + ".queryBurstText", ex.getMessage());
            result.setCode(400);
            result.setMsg("查询爆文失败!");
        }
        return result;
    }

    /**
     * @param burstId
     * @return
     */
    @Override
    public TabBurstText queryBurstTextInfo(String burstId) {
        return burstTextMapper.queryBurstText(burstId);
    }

    /**
     * 根据 url 拉取页面数据
     *
     * @param pageUrl
     * @return
     */
    public Result createBurstText(String pageUrl) {
        Result result = Result.responseSuccess();

        return result;
    }
}
