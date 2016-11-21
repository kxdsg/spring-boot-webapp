package com.web.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created by xingding on 2016/8/17.
 */
@Controller
public class IndexController {

    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private Environment env;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map){
        map.put("msg","Welcome to study spring boot!");
        logger.info("filepath: " + env.getProperty("file.path")); //测试不同环境读取不同配置属性
        return "index"; //html模板名称,对应/templates下的index.html
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
