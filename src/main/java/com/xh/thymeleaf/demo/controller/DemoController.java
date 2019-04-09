package com.xh.thymeleaf.demo.controller;

import com.xh.thymeleaf.demo.utils.ThymeleafUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name DemoController
 * @Description
 * @Author wen
 * @Date 2019-04-09
 */
@Controller
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private TemplateEngine templateEngine;


    @GetMapping("/index")
    public String index(Model model){
        List<String> list = new ArrayList<>();
        list.add("需求");
        list.add("成果");
        list.add("人力");
        list.add("进度");
        model.addAttribute("name", "生成静态页面的模板页");
        model.addAttribute("array", list);
        return "index";
    }

    @GetMapping("/create")
    @ResponseBody
    public String create() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "test create page!");
        List<String> list = new ArrayList<>();
        list.add("以前，");
        list.add("我们想方设法，");
        list.add("实现动态页面，");
        list.add("但是现在，");
        list.add("我们却使用方法让页面静态化！");
        dataMap.put("array", list);
        String file = "src/main/resources/templates/result.html";
        String content = ThymeleafUtil.generatePage(templateEngine, "index", dataMap, file);
        log.info("generated html content:{}", content);
        return "Page generated successfully!";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

}
