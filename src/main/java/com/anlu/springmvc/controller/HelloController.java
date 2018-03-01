package com.anlu.springmvc.controller;

import com.anlu.springmvc.model.User;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {


    private static final Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){

        // 动态跳转页面
        return formName;
    }

    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String register(User user,
            Model model) {
        logger.info(user);
        model.addAttribute("user", user);
        return "success";
    }

}