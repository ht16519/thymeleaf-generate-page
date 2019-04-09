package com.xh.thymeleaf.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @Name PageStaticConfig
 * @Description
 * @Author wen
 * @Date 2019-04-09
 */
@Configuration
public class PageStaticConfig {

    @Bean
    public TemplateEngine emailTemplateEngine() {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(springTemplateResolver());
        return templateEngine;
    }
    private ITemplateResolver springTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        thymeleaf:
//        prefix: classpath:/templates/
//        check-template-location: true
//        suffix: .html
//        mode: LEGACYHTML5
//        encoding: UTF-8
//        cache: false
        templateResolver.setOrder(1);
        templateResolver.setPrefix("classpath:/templates");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
}
