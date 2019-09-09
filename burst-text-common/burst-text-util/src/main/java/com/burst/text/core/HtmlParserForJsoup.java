package com.burst.text.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 使用 jsoup 对HTML页面进行解析
 *
 * @author Administrator
 */
public class HtmlParserForJsoup {

    /**
     * 根据 html url 将内容转为 Document 对象
     *
     * @param htmlUrl
     * @return
     */
    public static Document parseDocumentFromUrl(String htmlUrl) {
        Document doc = null;
        try {
            //doc = Jsoup.connect(htmlUrl).get();
            //获取标题
            /**String title = doc.title();
             System.out.println(title);*/

            /**
             * 如果报错：org.jsoup.HttpStatusException: HTTP error fetching URL. Status=403, URL=...
             * 这说明url的网站采用了策略禁止此类访问，需要模仿浏览器行为，可以使用如下方式：
             */


            doc = Jsoup.connect(htmlUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31 Micromessenger")
                    .timeout(3600)
                    .get();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return doc;
    }

    public static void parseDocumentToObj(Document doc) {
        System.out.println("标题：" + doc.title());
        Elements elements = doc.getAllElements();
        System.out.println("标题：" + doc.getElementsByTag("body").toString());
    }

    public static void main(String[] args) {
        String htmlUrl = "https://wxd.sznews.com/ttwap/20180717/content_251411.html";//"http://share.tuokkd.com/showd/id/1QnDBTdj8.html";
        Document doc = parseDocumentFromUrl(htmlUrl);
        parseDocumentToObj(doc);
        //System.out.println(doc);
    }
}
