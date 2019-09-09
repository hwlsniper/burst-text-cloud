package com.burst.text.service.upload;

import com.burst.text.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片上传
 */
@Service
public interface UploadService {

    /**
     * 上传单张图片
     *
     * @param file
     * @param request
     * @return
     */
    String uploadImg(MultipartFile file, HttpServletRequest request);

    /**
     * 上传多张图片
     *
     * @param request
     * @return
     */
    String uploadImgs(HttpServletRequest request);

    /**
     * 根据图片路径 上传
     *
     * @param file
     * @param request
     * @return
     */
    String uploadImg(String file, HttpServletRequest request);

    /**
     * 上传图片 (头像二维码)
     *
     * @param mfile
     * @return
     */
    Result uploadImg(MultipartFile mfile, Integer flag);

    /**
     * 根据目录遍历上传文件
     *
     * @param filePath    目录
     * @param posertType  海报类型 或 课件类型
     * @param type        icon  cover
     * @param cousreClass 课件类型(PDF\音频\视频)
     * @return
     */
    Result uploadImgs(String filePath, String posertType, String type, String cousreClass);
}
