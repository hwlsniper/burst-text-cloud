package com.burst.text.img;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EditImgUtil {

    /**
     * 指定大小进行缩放
     *
     * @param fromImg
     * @param toImg
     * @param width
     * @param heigth
     * @throws IOException
     */
    public static void imgZoom(String fromImg, String toImg, int width, int heigth) throws IOException {
        Thumbnails.of(fromImg)
                .size(width, heigth)
                .toFile(toImg);
    }

    /**
     * 按比例缩放
     *
     * @param fromImg
     * @param toImg
     * @param ratio
     * @throws IOException
     */
    public static void imgZoom(String fromImg, String toImg, float ratio) throws IOException {
        Thumbnails.of(fromImg)
                .scale(ratio)
                .toFile(toImg);
    }

    /**
     * 不按照比例，指定大小进行缩放
     *
     * @param fromImg
     * @param toImg
     * @param width
     * @param heigth
     * @throws IOException
     */
    public static void imgZoomNotPro(String fromImg, String toImg, int width, int heigth) throws IOException {
        Thumbnails.of(fromImg)
                .size(width, heigth)
                .keepAspectRatio(false)
                .toFile(toImg);
    }

    /**
     * 旋转
     *
     * @param fromImg
     * @param toImg
     * @param width
     * @param heigth
     * @param rotate  旋转的角度
     * @throws IOException
     */
    public static void rotateImg(String fromImg, String toImg, int width, int heigth, int rotate) throws IOException {
        Thumbnails.of(fromImg)
                .size(width, heigth)
                .rotate(rotate)
                .toFile(toImg);
    }

    /**
     * 添加水印
     *
     * @param fromImg
     * @param width
     * @param heigth
     * @param positions
     * @param wmImg
     * @param wmRatio
     * @param ratio
     * @param toImg
     * @throws IOException
     */
    public static void watermark(String fromImg, int width, int heigth,
                                 Position positions, String wmImg, float wmRatio,
                                 float ratio, String toImg) throws IOException {
        Thumbnails.of(fromImg)
                .size(width, heigth)
                .watermark(positions, ImageIO.read(new File(wmImg)), wmRatio)
                .outputQuality(ratio)
                .toFile(toImg);
    }

    /**
     * 裁剪 -- 指定大小
     *
     * @param fromImg
     * @param positions
     * @param trimWidth
     * @param trimHeigth
     * @param width
     * @param heigth
     * @param toImg
     * @throws IOException
     */
    public static void trimMakeSize(String fromImg, Position positions,
                                    int trimWidth, int trimHeigth,
                                    int width, int heigth, String toImg) throws IOException {
        Thumbnails.of(fromImg)
                .sourceRegion(positions, trimWidth, trimHeigth)
                .size(width, heigth)
                .keepAspectRatio(false)
                .toFile(toImg);
    }

    /**
     * 裁剪 -- 按坐标
     *
     * @param fromImg
     * @param xCoordinate
     * @param yCoordinate
     * @param trimWidth
     * @param trimHeigth
     * @param width
     * @param heigth
     * @param toImg
     * @throws IOException
     */
    public static void trimRatio(String fromImg, int xCoordinate, int yCoordinate,
                                 int trimWidth, int trimHeigth,
                                 int width, int heigth, String toImg) throws IOException {
        Thumbnails.of(fromImg)
                .sourceRegion(xCoordinate, yCoordinate, trimWidth, trimHeigth)
                .size(width, heigth)
                .keepAspectRatio(false)
                .toFile(toImg);
    }

    /**
     * 转化图像格式
     *
     * @param fromImg
     * @param width
     * @param heigth
     * @param suffix
     * @param toImg
     * @throws IOException
     */
    public static void formatConvert(String fromImg, int width, int heigth,
                                     String suffix, String toImg) throws IOException {
        Thumbnails.of(fromImg)
                .size(width, heigth)
                .outputFormat(suffix)
                .toFile(toImg);
    }

    /**
     * 输出到OutputStream
     *
     * @param toImg
     * @param fromImg
     * @param width
     * @param heigth
     * @throws IOException
     */
    public static void imgOutputStream(String toImg, String fromImg, int width, int heigth) throws IOException {
        OutputStream os = new FileOutputStream(toImg);
        Thumbnails.of(fromImg)
                .size(width, heigth)
                .toOutputStream(os);
    }

    /**
     * 输出到BufferedImage
     *
     * @param fromImg
     * @param width
     * @param heigth
     * @param suffix
     * @param toImg
     * @throws IOException
     */
    public static void imgBufferedImage(String fromImg, int width, int heigth, String suffix, String toImg) throws IOException {
        BufferedImage thumbnail = Thumbnails.of(fromImg)
                .size(width, heigth)
                .asBufferedImage();
        ImageIO.write(thumbnail, suffix, new File(toImg));
    }

    public static void main(String[] args) throws IOException {
        //1、指定大小进行缩放
        //size(宽度, 高度)

        /*
         * 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变
         * 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(200, 300)
                .toFile("c:/a380_200x300.jpg");

        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(2560, 2048)
                .toFile("c:/a380_2560x2048.jpg");

        //2、按照比例进行缩放
        //scale(比例)
        Thumbnails.of("images/a380_1280x1024.jpg")
                .scale(0.25f)
                .toFile("c:/a380_25%.jpg");

        Thumbnails.of("images/a380_1280x1024.jpg")
                .scale(1.10f)
                .toFile("c:/a380_110%.jpg");

        //3、不按照比例，指定大小进行缩放
        //keepAspectRatio(false) 默认是按照比例缩放的
        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile("c:/a380_200x200.jpg");

        //4、旋转
        //rotate(角度),正数：顺时针 负数：逆时针
        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .rotate(90)
                .toFile("c:/a380_rotate+90.jpg");

        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .rotate(-90)
                .toFile("c:/a380_rotate-90.jpg");

        //5、水印
        //watermark(位置，水印图，透明度)
        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("images/watermark.png")), 0.5f)
                .outputQuality(0.8f)
                .toFile("c:/a380_watermark_bottom_right.jpg");

        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .watermark(Positions.CENTER, ImageIO.read(new File("images/watermark.png")), 0.5f)
                .outputQuality(0.8f)
                .toFile("c:/a380_watermark_center.jpg");

        //6、裁剪
        //sourceRegion()
        //图片中心400*400的区域
        Thumbnails.of("images/a380_1280x1024.jpg")
                .sourceRegion(Positions.CENTER, 400, 400)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile("c:/a380_region_center.jpg");

        //图片右下400*400的区域
        Thumbnails.of("images/a380_1280x1024.jpg")
                .sourceRegion(Positions.BOTTOM_RIGHT, 400, 400)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile("c:/a380_region_bootom_right.jpg");

        //指定坐标
        Thumbnails.of("images/a380_1280x1024.jpg")
                .sourceRegion(600, 500, 400, 400)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile("c:/a380_region_coord.jpg");

        //7、转化图像格式
        //outputFormat(图像格式)
        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .outputFormat("png")
                .toFile("c:/a380_1280x1024.png");

        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .outputFormat("gif")
                .toFile("c:/a380_1280x1024.gif");


        //8、输出到OutputStream
        //toOutputStream(流对象)
        OutputStream os = new FileOutputStream("c:/a380_1280x1024_OutputStream.png");
        Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .toOutputStream(os);

        //9、输出到BufferedImage
        //asBufferedImage() 返回BufferedImage
        BufferedImage thumbnail = Thumbnails.of("images/a380_1280x1024.jpg")
                .size(1280, 1024)
                .asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File("c:/a380_1280x1024_BufferedImage.jpg"));

        //参考：https://www.cnblogs.com/haha12/p/4679829.html
    }
}
