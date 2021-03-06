package com.burst.text.service.course.impl;

import com.burst.text.entity.TabCourseInfo;
import com.burst.text.entity.TabMemberUser;
import com.burst.text.entity.TabSysDictionary;
import com.burst.text.enums.ResultCode;
import com.burst.text.mapper.TabCourseInfoMapper;
import com.burst.text.mapper.TabMemberUserMapper;
import com.burst.text.page.BTPage;
import com.burst.text.service.course.CourseWareService;
import com.burst.text.service.user.UserTokenService;
import com.burst.text.util.ImageUrlUtil;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课件 service
 */
@Service
public class CourseWareServiceImpl implements CourseWareService {

    private static final Logger logger = LoggerFactory.getLogger(CourseWareServiceImpl.class);

    @Autowired
    private UserTokenService tokenService;

    @Autowired
    private TabMemberUserMapper memberUserMapper;

    @Autowired
    private TabCourseInfoMapper courseInfoMapper;

    /**
     * 获取 课件类型(分类)
     *
     * @return
     */
    @Override
    public Result queryCourseType() {
        Result result = Result.responseSuccess();
        try {
            List<TabSysDictionary> list = courseInfoMapper.queryCourseType();
            result.setData(list);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", CourseWareServiceImpl.class.getName() + ".queryCourseType", ex.getMessage());
        }
        return result;
    }

    /**
     * 获取 课件列表数据
     *
     * @param param
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Result queryCourseWareList(Map<String, Object> param, int pageNum, int pageSize) {
        Result result = Result.responseSuccess();
        try {
            List<TabCourseInfo> list = new ArrayList<>();
            PageHelper.startPage(pageNum, pageSize);
            list = courseInfoMapper.queryCourseWareList(param);
            BTPage<TabCourseInfo> pages = new BTPage<>(list);
            result.setData(pages);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", CourseWareServiceImpl.class.getName() + ".queryCourseWareList", ex.getMessage());
        }
        return result;
    }

    /**
     * 获取 课件详情
     *
     * @param courseId
     * @return
     */
    @Override
    public Result queryCourseWare(String courseId) {
        Result result = Result.responseSuccess();
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("courseId", courseId);
            TabCourseInfo courseInfo = courseInfoMapper.queryCourseWare(param);
            param.clear();
            param.put("userId", tokenService.queryUserIdForToken());
            TabMemberUser memberUser = memberUserMapper.queryMemberUser(param);
            if (null != courseInfo && SysCommonConstant.USE_SCOPE_TYPE_VIP.equals(courseInfo.getUseScope()) && null == memberUser) {
                result.setCode(ResultCode.MEMBER_USED.getCode());
                result.setMsg("该课件只有会员才可以查看!");
                return result;
            }
            result.setData(courseInfo == null ? "" : ImageUrlUtil.getThumbnailUrl(courseInfo.getCouserUrl()));
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", CourseWareServiceImpl.class.getName() + ".queryCourseWare", ex.getMessage());
        }
        return result;
    }

    /**
     * 保存课件数据
     *
     * @param courseInfo
     * @return
     */
    @Override
    public Result saveCourseWare(TabCourseInfo courseInfo) {
        Result result = Result.responseSuccess();
        try {
            courseInfoMapper.saveCourseWare(courseInfo);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", CourseWareServiceImpl.class.getName() + ".saveCourseWare", ex.getMessage());
        }
        return result;
    }
}
