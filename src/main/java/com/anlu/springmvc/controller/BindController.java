package com.anlu.springmvc.controller;

import com.anlu.springmvc.convert.DateEditor;
import com.anlu.springmvc.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.rmi.runtime.Log;

import java.util.Date;

@Controller
@RequestMapping(value = "/bind")
public class BindController {

    private static Logger logger = Logger.getLogger(BindController.class);

    // 在控制器初始化时注册属性编辑器
    @InitBinder
    public void initBinder(WebDataBinder binder){
        // 注册自定义编辑器
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String register(User user,
            Model mode) {
        logger.info(user);
        mode.addAttribute("user", user);
        return "success";
    }
}
