package com.burst.text.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 文件上传 service
 */
@Service
public interface UploadService {

    String getFileExt(String fileType);

    Boolean checkExt(String extName);

    String fileSave(MultipartFile file, String diskPath, String filePath, String fileName);

    String fileSave(MultipartFile file, String filePath, String fileName);

    String ossSave(MultipartFile file, String filePath, String fileName);

    String qiniuSave(MultipartFile file, String filePath, String fileName);

    Map<String, String> getReturnMap(String retPath, String fileName);

    String getUploadUrl(String fileType);

    String getUploadPath(String extName);

    Map<String, String> getAccessPath(String retPath, String fileName);
}
