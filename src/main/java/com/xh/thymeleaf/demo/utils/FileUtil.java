package com.xh.thymeleaf.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.thymeleaf.TemplateEngine;

import java.io.File;
import java.io.IOException;

/**
 * @Name FileUtil
 * @Description 文件操作工具类
 * @Author wen
 * @Date 2019-04-09
 */
@Slf4j
public class FileUtil {

    /**
     *  默认输出字符集
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
    * @Name writeStringToFile
    * @Description 输出内容到文件
    * @Author wen
    * @Date 2019/4/9
    * @param content
    * @param filePath
    * @return void
    */
    public static void writeToFile(String content, String filePath) {
        File file = new File(filePath);
        try {
            FileUtils.writeStringToFile(file, content, DEFAULT_CHARSET);
        } catch (IOException e) {
            log.error("create static file failed exception:{}", e);
        }
    }


}
