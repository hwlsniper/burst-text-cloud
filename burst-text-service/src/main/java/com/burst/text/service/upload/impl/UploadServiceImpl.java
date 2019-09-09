package com.burst.text.service.upload.impl;

import com.burst.text.entity.TabCourseInfo;
import com.burst.text.entity.TabPosterTemplate;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.service.course.CourseWareService;
import com.burst.text.service.poster.PosterService;
import com.burst.text.service.upload.UploadService;
import com.burst.text.service.user.UserService;
import com.burst.text.service.user.UserTokenService;
import com.burst.text.util.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * 图片上传
 */
@Service
@ConfigurationProperties(prefix = "web.upload-path")
public class UploadServiceImpl implements UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    public static final IdWorker idWork = new IdWorker();

    @Autowired
    private PosterService posterService;

    @Autowired
    private CourseWareService courseWareService;

    @Autowired
    private UserTokenService tokenService;

    @Autowired
    private UserService userService;

    @Getter
    @Setter
    @Value("${headIcon}")
    private String headIcon;

    @Getter
    @Setter
    @Value("${posterTemp}")
    private String posterTemp;

    @Getter
    @Setter
    @Value("${rqcodeIcon}")
    private String rqcodeIcon;

    @Getter
    @Setter
    @Value("${courseFile}")
    private String courseFile;

    @Getter
    @Setter
    @Value("${courseImage}")
    private String courseImage;

    @Getter
    @Setter
    @Value("${burstImgs}")
    private String burstImgs;

    @Getter
    @Setter
    @Value("${defaultPath}")
    private String defaultPath;

    /**
     * 上传 单张图片
     *
     * @param file
     * @param request
     * @return
     */
    @Override
    public String uploadImg(MultipartFile file, HttpServletRequest request) {
        try {
            //取得上传文件
            if (file == null) {
                return null;
            }
            return upload(file, request);
        } catch (Exception ex) {
            logger.error("单张图片上传,异常方法:{}异常信息:{}", UploadServiceImpl.class.getName() + ".uploadImg", ex.getMessage());
            return null;
        }
    }

    /**
     * 上传 多张图片
     *
     * @param request
     * @return
     */
    @Override
    public String uploadImgs(HttpServletRequest request) {
        try {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            System.out.println(iter.hasNext());
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile mfile = multiRequest.getFile(iter.next());
                if (mfile != null) {
                    upload(mfile, request);
                }
            }
        } catch (Exception ex) {
            logger.error("多张图片上传,异常方法:{}异常信息:{}", UploadServiceImpl.class.getName() + ".uploadImgs", ex.getMessage());
        }
        return null;
    }

    /**
     * 上传图片
     *
     * @param file
     * @param request
     * @return
     */
    @Override
    public String uploadImg(String file, HttpServletRequest request) {
        if (StringUtils.isEmpty(file)) {
            return null;
        }
        String imgpath = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
            String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/temp");
            File tfile = new File(realPath + File.separatorChar + dateFormat.format(new Date()) + ".jpg");
            //需要去掉头部信息，这很重要
            file = file.substring(file.indexOf(",") + 1);
            FileUtils.copyInputStreamToFile(new ByteArrayInputStream(decodeBase64ToImage(file)), tfile);
            //imgpath = imWebUtil.uploadFile(tfile.getName(),"academy-server",tfile,"1");
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", UploadServiceImpl.class.getName() + ".uploadImgs", ex.getMessage());
        }
        return imgpath;
    }

    /**
     * 图片文件上传
     *
     * @param mfile
     * @param request
     * @return
     * @throws IOException
     */
    private String upload(MultipartFile mfile, HttpServletRequest request) throws IOException {
        //取得当前上传文件的文件名称
        String fileName = mfile.getOriginalFilename();
        System.out.println(fileName);
        // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
        if (StringUtils.isNotBlank(fileName)) {
            final String businessNo = "";
            String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/temp");
            String filename = mfile.getContentType();
            String fileType = filename.substring(filename.lastIndexOf("/") + 1, filename.length()).toLowerCase();
            fileType = "." + fileType;
            File tfile = new File(realPath + File.separatorChar + businessNo + fileType);
            System.out.println(tfile.getPath());
            FileUtils.copyInputStreamToFile(mfile.getInputStream(), tfile);
        }
        return null;
    }

    /**
     * 上传图片 (头像和二维码)
     *
     * @param file
     * @param flag 1-头像  2-二维码
     * @return
     */
    @Override
    public Result uploadImg(MultipartFile file, Integer flag) {
        Result result = Result.responseSuccess();
        String userId = tokenService.queryUserIdForToken();
        if (StringUtils.isBlank(userId)) {
            result.setCode(400);
            result.setMsg("未获取到用户信息无法上传图片!");
            return result;
        }
        String root_fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        logger.info("上传图片:name={},type={}", root_fileName, contentType);
        //获取路径
        String return_path = "";
        String location = defaultPath;
        if (null != flag && SysCommonConstant.HEADICON_NUMBER.equals(flag)) {
            location = headIcon;
        } else if (null != flag && SysCommonConstant.RQCODEICON_NUMBER.equals(flag)) {
            location = headIcon;
        }

        String filePath = location + return_path;

        try {
            String file_name = saveImg(file, filePath);
            logger.info("图片保存路径={}", filePath + File.separator + file_name);
            if (StringUtils.isNotBlank(file_name)) {
                //保存图片
                TabUserInfo userInfo = new TabUserInfo();
                userInfo.setId(userId);
                if (null != flag && SysCommonConstant.HEADICON_NUMBER.equals(flag)) {
                    userInfo.setHeadIcon(file_name);
                } else if (null != flag && SysCommonConstant.RQCODEICON_NUMBER.equals(flag)) {
                    userInfo.setWxqrCode(file_name);
                }
                userService.updateUserInfo(userInfo);

                //result.setData(return_path+File.separator+file_name);
                result.setData(ImageUrlUtil.getThumbnailUrl(file_name));
            }
        } catch (IOException e) {
            logger.error("异常方法:{}异常信息:{}", UploadServiceImpl.class.getName() + ".uploadImg", e.getMessage());
            result.setCode(400);
            result.setMsg("图片上传有误!");
        }
        return result;
    }

    /**
     * 保存文件，直接以multipartFile形式
     *
     * @param multipartFile
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    private static String saveImg(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = Constants.getUUID() + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

    /**
     * 根据目录上传文件
     *
     * @param filePath    目录  (用于处理海报和课件相关的图片)
     * @param posertType  海报类型 或 课件类型
     * @param type        icon  cover
     * @param cousreClass 课件类型(PDF\音频\视频)
     * @return
     */
    @Override
    public Result uploadImgs(String filePath, String posertType, String type, String cousreClass) {
        Result result = Result.responseSuccess();
        try {
            //获取其file对象
            File file = new File(filePath);
            recurseImgs(file, posertType, type, cousreClass);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", UploadServiceImpl.class.getName() + ".uploadImgs", ex.getMessage());
        }
        return result;
    }

    /**
     * 递归上传文件
     *
     * @param file
     * @param type icon  cover
     */
    private void recurseImgs(File file, String posertType, String type, String cousreClass) throws IOException {
        File[] fs = file.listFiles();
        for (File f : fs) {
            //若是目录，则递归打印该目录下的文件
            if (f.isDirectory()) {
                recurseImgs(f, posertType, type, cousreClass);
            }

            //若是文件，直接上传
            if (f.isFile() && !f.getName().contains(type)) {
                if (type.equals("cover")) {
                    uploadCourse(f, posertType, type, cousreClass);
                } else {
                    uploadPoster(f, posertType, type);
                }
            }
        }
    }

    /**
     * @param file
     * @param couserType
     * @param type
     * @throws IOException
     */
    private void uploadCourse(File file, String couserType, String type, String cousreClass) throws IOException {
        //获取文件名称(包含后缀的)
        String fileName = file.getName();
        //获取文件路径
        String file_Path = file.getPath();
        file_Path = file_Path.substring(0, file_Path.lastIndexOf("\\"));
        //文件名(不包含后缀的)
        String file_name = fileName.substring(0, fileName.lastIndexOf("."));
        //文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        //课件图片
        String course_img = file_Path + File.separator + file_name + "_" + type + ".png";
        //获取课件图片
        File cImgFile = new File(course_img);

        //判断课件目录是否创建
        File cf = new File(courseFile);
        if (!cf.exists()) {
            cf.mkdirs();
        }

        //判断课件图片目录是否创建
        File ci = new File(courseImage);
        if (!ci.exists()) {
            ci.mkdirs();
        }

        //创建课件文件
        String cFile = Constants.getUUID() + "." + suffix;
        //创建课件图片
        String cImage = Constants.getUUID() + ".png";

        //拼接成完整的指定的文件路径名，创建新文件
        String courseFilePath = courseFile + File.separator + cFile;
        String courseImagePath = courseImage + File.separator + cImage;

        //创建文件
        File courseFile = new File(courseFilePath);
        File courseImage = new File(courseImagePath);

        if (courseFile.exists()) {
            courseFile.delete();
        }
        if (courseImage.exists()) {
            courseImage.delete();
        }

        //使用输入流读取前台的file文件
        InputStream coursePDFIS = new FileInputStream(file);
        //循环读取输入流文件内容，通过输出流将内容写入新文件
        OutputStream coursePDFOS = new FileOutputStream(courseFile);

        byte[] coursePDBuff = new byte[1024];
        int coursePDCNT = 0;
        while ((coursePDCNT = coursePDFIS.read(coursePDBuff)) > 0) {
            coursePDFOS.write(coursePDBuff, 0, coursePDCNT);
        }

        //使用输入流读取前台的file文件
        InputStream courseImgIS = new FileInputStream(cImgFile);
        //循环读取输入流文件内容，通过输出流将内容写入新文件
        OutputStream courseImgOS = new FileOutputStream(courseImage);

        byte[] courseImgBuff = new byte[1024];
        int courseImgCNT = 0;
        while ((courseImgCNT = courseImgIS.read(courseImgBuff)) > 0) {
            courseImgOS.write(courseImgBuff, 0, courseImgCNT);
        }

        TabCourseInfo courseInfo = new TabCourseInfo();
        courseInfo.setId(idWork.nextId());
        courseInfo.setCouserTitle(file_name);
        courseInfo.setCourseImg(cImage);
        courseInfo.setCouserUrl(cFile);
        courseInfo.setCouserType(couserType);
        courseInfo.setCouserClass(cousreClass);

        courseWareService.saveCourseWare(courseInfo);

        coursePDFOS.close();
        coursePDFIS.close();
        courseImgOS.close();
        courseImgIS.close();
    }

    /**
     * 上传图片(海报)
     *
     * @param file
     * @param posertType
     */
    private void uploadPoster(File file, String posertType, String type) throws IOException {
        //获取文件名称(包含后缀的)
        String fileName = file.getName();
        //获取文件路径
        String file_Path = file.getPath();
        file_Path = file_Path.substring(0, file_Path.lastIndexOf("\\"));
        //文件名(不包含后缀的)
        String file_name = fileName.substring(0, fileName.lastIndexOf("."));
        //文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        String icon_path = file_Path + File.separator + file_name + "_" + type + "." + suffix;
        //获取海报小图文件
        File minFile = new File(icon_path);

        //创建海报大图文件名
        String maxPoster = Constants.getUUID() + "." + suffix;
        //创建海报小图文件名
        String minPoster = Constants.getUUID() + "." + suffix;

        //判断目录是否存在,不存在则创建目录
        File dir = new File(posterTemp);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //拼接成完整的指定的文件路径名，创建新文件
        String maxFilePath = posterTemp + File.separator + maxPoster;
        String minFilePath = posterTemp + File.separator + minPoster;

        //创建文件
        File newMaxFile = new File(maxFilePath);
        File newMinFile = new File(minFilePath);

        if (newMaxFile.exists()) {
            newMaxFile.delete();
        }
        if (newMinFile.exists()) {
            newMinFile.delete();
        }

        //使用输入流读取前台的file文件
        InputStream maxIS = new FileInputStream(file);
        //循环读取输入流文件内容，通过输出流将内容写入新文件
        OutputStream maxOS = new FileOutputStream(newMaxFile);

        byte[] maxBuff = new byte[1024];
        int maxCNT = 0;
        while ((maxCNT = maxIS.read(maxBuff)) > 0) {
            maxOS.write(maxBuff, 0, maxCNT);
        }

        //使用输入流读取前台的file文件
        InputStream minIS = new FileInputStream(minFile);
        //循环读取输入流文件内容，通过输出流将内容写入新文件
        OutputStream minOS = new FileOutputStream(newMinFile);

        byte[] minBuff = new byte[1024];
        int minCNT = 0;
        while ((minCNT = minIS.read(minBuff)) > 0) {
            minOS.write(minBuff, 0, minCNT);
        }

        TabPosterTemplate poster = new TabPosterTemplate();
        poster.setId(idWork.nextId());
        poster.setMaxPoster(maxPoster);
        poster.setMinPoster(minPoster);
        poster.setPosterTitle(file_name);
        poster.setPosterType(posertType);

        //保存海报信息(在正真的微服务中,此处应该是根据uri调用接口<Feign>)
        posterService.savePoster(poster);

        maxOS.close();
        maxIS.close();
        minOS.close();
        minIS.close();
    }

    /**
     * 将 base64 转为字节数组
     *
     * @param base64
     * @return
     */
    private byte[] decodeBase64ToImage(String base64) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] decoderBytes = null;
        try {
            //解码
            decoderBytes = base64Decoder.decodeBuffer(base64);
            for (int i = 0; i < decoderBytes.length; ++i) {
                // 调整异常数据
                if (decoderBytes[i] < 0) {
                    decoderBytes[i] += 256;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decoderBytes;
    }
}
