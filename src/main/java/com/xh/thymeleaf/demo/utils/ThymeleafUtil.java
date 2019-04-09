package com.xh.thymeleaf.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Name ThymeleafUtil
 * @Description Thymeleaf工具类
 * @Author wen
 * @Date 2019-04-09
 */
@Slf4j
public class ThymeleafUtil {

    /**
     *  默认字符集UTF-8
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
    * @Name getContext
    * @Description 隐藏Thymeleaf细节, 直到在渲染数据前都使用Map存储数据
    * @Author wen
    * @Date 2019/4/9
    * @param Context
    * @return  
    */
    public static Context getContext(Map<String, Object> dataMap) {
        Context ctx = new Context();
        for (Map.Entry<String, Object> dataEntry : dataMap.entrySet()) {
            ctx.setVariable(dataEntry.getKey(), dataEntry.getValue());
        }
        return ctx;
    }

    /**
    * @Name generatePage
    * @Description 使用Thymeleaf生成静态页面
    * @Author wen
    * @Date 2019/4/9
    * @param templateEngine 模板引擎
    * @param template 源模板
    * @param dataMap 数据Map集合
    * @param filePath 生成文件全路径
    * @return java.lang.String 生成的文件的内容
    */
    public static String generatePage(TemplateEngine templateEngine, String template, Map<String, Object> dataMap, String filePath) {
        File file = new File(filePath);
        //预生产文件的内容
        String content = templateEngine.process(template, ThymeleafUtil.getContext(dataMap));
        try {
            FileUtils.writeStringToFile(file, content, DEFAULT_CHARSET);
        } catch (IOException ex) {
            log.error("create static file failed exception:{}", ex);
        }
        return content;
    }

}


