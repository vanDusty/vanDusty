package com.van.dusty.controller;

import com.van.dusty.model.UserDO;
import com.van.dusty.service.UserService;
import com.van.dusty.util.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class LoginController {

    @Resource
    UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/LoginView");
        return mv;
    }

    @PostMapping("/toLogin")
    @ResponseBody
    public ResultMsg toLogin(UserDO userDO) {
        ResultMsg result = userService.userLogin(userDO);
        return result;
    }
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/RegisterView");
        return mv;
    }

    @PostMapping("/doRegister")
    @ResponseBody
    public ResultMsg doRegister(UserDO userDO) {
        return userService.registerAccount(userDO);
    }
}
