package com.burst.text.web;

import com.burst.text.model.BurstTextBean;
import com.burst.text.model.BurstTextInfo;
import com.burst.text.model.SysDictionaryBean;
import com.burst.text.service.BurstTextService;
import com.burst.text.service.SysDictionaryService;
import com.burst.text.util.ReturnUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 爆文
 */
@Controller
@RequestMapping("console/burst/")
public class BurstTextController {

    @Autowired
    private BurstTextService burstTextService;

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @GetMapping("index")
    public String index() {

        return "console/burst/index";
    }

    @ResponseBody
    @GetMapping("list")
    public ModelMap list(HttpServletRequest request) {
        ModelMap map = new ModelMap();
        Map<String, Object> param = new HashMap<>();
        PageInfo<BurstTextBean> pages = burstTextService.queryBurstList(param, 1, 10);
        map.put("pageInfo", pages);
        return ReturnUtil.Success("加载成功", map, null);
    }

    @GetMapping("from")
    public String addBurst(String burstId, Model model) throws Exception {
        BurstTextInfo burstText = new BurstTextInfo();
        if (StringUtils.isNotBlank(burstId)) {
            burstText = burstTextService.queryBurstText(burstId);
        }
        List<SysDictionaryBean> burstTypeLists = sysDictionaryService.querySysDictList("burst_type");
        model.addAttribute("burstText", burstText);
        model.addAttribute("burstTypeLists", burstTypeLists);
        return "console/burst/from";
    }

    @ResponseBody
    @PostMapping("save")
    public ModelMap saveBurst(BurstTextInfo burstInfo) {
        try {
            if (null == burstInfo) {
                return ReturnUtil.Error("数据不可为空!", null, null);
            }
            if (StringUtils.isBlank(burstInfo.getTitle())) {
                return ReturnUtil.Error("请填写标题!", null, null);
            }
            if (StringUtils.isBlank(burstInfo.getBurstType())) {
                return ReturnUtil.Error("请选择爆文类型!", null, null);
            }
            if (StringUtils.isBlank(burstInfo.getContent())) {
                return ReturnUtil.Error("请填写内容!", null, null);
            }
            if (StringUtils.isNotBlank(burstInfo.getTitleImg()) && burstInfo.getTitleImg().contains(",")) {
                burstInfo.setTitleImg(burstInfo.getTitleImg().substring(0, burstInfo.getTitleImg().length() - 1));
            }
            burstTextService.saveBurstText(burstInfo);
            return ReturnUtil.Success("保存成功!", null, "console/burst/index");
        } catch (Exception e) {
            return ReturnUtil.Error("保存失败!", null, "console/burst/index");
        }
    }

    @ResponseBody
    @PostMapping("releaseTop")
    public ModelMap releaseTop(@RequestParam String burstId, Integer mark, String editType) {
        try {
            burstTextService.releaseTop(burstId, mark, editType);
            return ReturnUtil.Success("修改成功!", null, "console/burst/index");
        } catch (Exception ex) {
            return ReturnUtil.Error("修改失败!", null, "console/burst/index");
        }
    }
}
