package com.burst.text.service.poster;

import com.burst.text.entity.TabPosterTemplate;
import com.burst.text.util.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PosterService {

    /**
     * 获取海报类型
     *
     * @return
     */
    Result queryPosterType();

    /**
     * 获取海报列表数据
     *
     * @param param
     * @return
     */
    Result queryPosterList(Map<String, Object> param, int pageNum, int pageSize);

    /**
     * 获取海报信息
     *
     * @param param
     * @return
     */
    Result queryPoster(Map<String, Object> param);

    /**
     * 获取用户姓名、头像、电话、二维码(或平台的)
     *
     * @param flag
     * @return
     */
    Result queryUserInfo(int flag);

    /**
     * 保存海报信息
     *
     * @param poster
     * @return
     */
    Result savePoster(TabPosterTemplate poster);
}
