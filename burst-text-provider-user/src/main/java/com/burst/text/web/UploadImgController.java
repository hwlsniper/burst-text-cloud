package com.burst.text.web;

import com.burst.text.service.upload.UploadService;
import com.burst.text.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片上传
 */
@RestController
public class UploadImgController {

    @Autowired
    private UploadService uploadService;

    /**
     * 上传图片(头像)
     *
     * @param request
     * @param img
     * @param flag    1-头像  2-二维码
     * @return
     */
    @PostMapping("/user/uploadImg/{flag}")
    public Result uploadImg(HttpServletRequest request, MultipartFile img,
                            @PathVariable("flag") Integer flag) {
        Result result = Result.responseSuccess();
        if (img.isEmpty() || StringUtils.isBlank(img.getOriginalFilename())) {
            result.setCode(400);
            result.setMsg("请选择上传的图片!");
            return result;
        }

        String contentType = img.getContentType();
        if (!contentType.contains("")) {
            result.setCode(400);
            result.setMsg("上传的图片格式有误,请重新选择!");
            return result;
        }

        result = uploadService.uploadImg(img, flag);
        return result;
    }

    /**
     * 遍历目录中的文件,并将文件上传
     *
     * @param filePath    目录
     * @param posertType  海报类型、课件类型
     * @param type        图片名后缀
     * @param cousreClass 课件类型(PDF\音频\视频)
     * @return
     */
    @PostMapping("/user/uploadImgs")
    public Result uploadImgs(String filePath, String posertType, String type, String cousreClass) {
        Result result = Result.responseSuccess();
        uploadService.uploadImgs(filePath, posertType, type, cousreClass);
        return result;
    }
}
