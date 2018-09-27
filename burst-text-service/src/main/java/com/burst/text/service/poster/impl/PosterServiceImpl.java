package com.burst.text.service.poster.impl;

import com.burst.text.dto.PosterTypeBean;
import com.burst.text.entity.TabPosterTemplate;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.mapper.TabPosterTemplateMapper;
import com.burst.text.service.poster.PosterService;
import com.burst.text.service.user.UserService;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 海报 service
 */
@Service
public class PosterServiceImpl implements PosterService {

    private static final Logger logger = LoggerFactory.getLogger(PosterServiceImpl.class);

    @Autowired
    private TabPosterTemplateMapper posterMapper;

    @Autowired
    private UserService userService;

    /**
     * 获取海报类型
     * @return
     */
    @Override
    public Result queryPosterType() {
        Result result = Result.responseSuccess();
        try{
            List<PosterTypeBean> posterTypes = posterMapper.queryPosterType();
            result.setData(posterTypes);
        }catch(Exception ex){
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName()+".queryPosterType", ex.getMessage());
        }
        return result;
    }

    /**
     * 获取海报列表数据
     * @param param
     * @return
     */
    @Override
    public Result queryPosterList(Map<String, Object> param, int pageNum, int pageSize) {
        Result result = Result.responseSuccess();
        try{
            List<TabPosterTemplate> list = new ArrayList<>();
            PageHelper.startPage(pageNum, pageSize);
            list = posterMapper.queryPosterTempList(param);
            result.setData(list);
        }catch(Exception ex){
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName()+".queryPosterList", ex.getMessage());
        }
        return result;
    }

    /**
     * 获取海报信息
     * @param param
     * @return
     */
    @Override
    public Result queryPoster(Map<String, Object> param){
        Result result = Result.responseSuccess();
        try{
            //首先判断用户是否是会员或购买该海报
            //伪代码

            result.setData(posterMapper.queryPosterInfo(param));
        }catch(Exception ex){
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName()+".queryPoster", ex.getMessage());
        }
        return result;
    }

    /**
     * 获取用户姓名、头像、电话、二维码(或平台的)
     * @param flag
     * @return
     */
    @Override
    public Result queryUserInfo(int flag) {
        Result result = Result.responseSuccess();
        try{
            //获取用户信息(尽量少量的数据,减少流量的损耗)
            TabUserInfo userInfo = userService.getUserInfo();
            //获取平台二维码
            if(flag == SysCommonConstant.DEFAULT_COMMON_ONE){

            }
        }catch(Exception ex){
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName()+".queryUserInfo", ex.getMessage());
        }
        return result;
    }
}