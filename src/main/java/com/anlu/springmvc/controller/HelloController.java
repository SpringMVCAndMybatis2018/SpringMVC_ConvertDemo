package com.anlu.springmvc.controller;

import com.anlu.springmvc.model.JsrUser;
import com.anlu.springmvc.model.User;
import com.anlu.springmvc.validator.UserValidator;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HelloController {


    private static final Logger logger = Logger.getLogger(HelloController.class);

    // 注入UserValidator对象
    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;

    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName,Model model){
        User user = new User();
        model.addAttribute("user",user);
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


    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(
            @ModelAttribute User user,
            Model model,
            Errors errors) {
        logger.info(user);
        model.addAttribute("user", user);
        // 调用userValidator的验证方法
        userValidator.validate(user, errors);
        // 如果验证不通过跳转到loginForm视图
        if(errors.hasErrors()){
            return "loginForm";
        }
        return "success";
    }


    @RequestMapping(value="/jsr")
    public String loginForm(Model model){
        JsrUser user = new JsrUser();
        model.addAttribute("user",user);
        // 动态跳转页面
        return "jsrRegisterForm";
    }
    // 数据校验使用@Valid，后面跟着Errors对象保存校验信息
    @RequestMapping(value="/loginJSR",method=RequestMethod.POST)
    public String login(
            @Valid @ModelAttribute  JsrUser user,
            Errors  errors,
            Model model) {
        logger.info(user);
        if(errors.hasErrors()){
            model.addAttribute("user", user);
            return "jsrRegisterForm";
        }
        model.addAttribute("user", user);
        return "jsrsuccess";
    }
}
