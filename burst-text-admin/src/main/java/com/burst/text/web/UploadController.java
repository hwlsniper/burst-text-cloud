package com.burst.text.web;

import com.burst.text.config.UploadConfig;
import com.burst.text.model.UploadBean;
import com.burst.text.service.UploadService;
import com.burst.text.util.ReturnUtil;
import com.burst.text.util.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

/**
 * 文件上传
 */
@Controller
@RequestMapping("console/upload/")
public class UploadController {

    @Resource
    private UploadConfig upConfig;

    @Autowired
    private UploadService uploadService;

    @GetMapping("index")
    public String index(Model model, UploadBean upload) {
        upload.setFileExt(uploadService.getFileExt(upload.getFileType()));
        upload.setMaxSize(upConfig.getMaxFileSize());
        model.addAttribute("upload", upload);
        return "console/upload/upload";
    }

    @ResponseBody
    @PostMapping("/uploader")
    public ModelMap postUploader(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        if (!file.isEmpty()) {
            if (StringUtils.isEmpty(upConfig.getHardDisk()) && "local".equals(upConfig.getUpType())) {
                return ReturnUtil.Error("请配置上传目录");
            }
            String diskPath = upConfig.getHardDisk();
            //扩展名格式
            String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //验证文件类型
            if (!uploadService.checkExt(extName)) {
                return ReturnUtil.Error("上传文件格式不支持");
            }
            //根据文件类型获取上传目录
            String fileType = request.getParameter("fileDir");
            //String uploadPath = uploadService.getUploadPath(extName);
            String uploadPath = uploadService.getUploadUrl(fileType);
            uploadPath = uploadPath.replace(File.separator, "/");
            if (StringUtils.isEmpty(uploadPath)) {
                return ReturnUtil.Error("上传文件路径错误");
            }
            String fileName = UuidUtil.getUUID() + extName;
            String retPath = "";
            if ("local".equals(upConfig.getUpType()) && StringUtils.isNotEmpty(upConfig.getUpType())) {
                //retPath = uploadService.fileSave(file, diskPath, uploadPath, fileName);
                retPath = uploadService.fileSave(file, uploadPath, fileName);
            } else if ("oss".equals(upConfig.getUpType())) {
                retPath = uploadService.ossSave(file, uploadPath, fileName);
            } else if ("qiniu".equals(upConfig.getUpType())) {
                retPath = uploadService.qiniuSave(file, uploadPath, fileName);
            }
            if ("null".equals(retPath)) {
                return ReturnUtil.Error("上传文件异常");
            }
            //Map<String, String> upMap = uploadService.getReturnMap(retPath, fileName);
            Map<String, String> upMap = uploadService.getAccessPath(retPath, fileName);
            return ReturnUtil.Success("上传成功", upMap);
        } else {
            return ReturnUtil.Error("上传文件为空,");
        }
    }
}
