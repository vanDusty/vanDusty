package com.van.dusty.controller;

import com.van.dusty.model.UserDO;
import com.van.dusty.service.UserService;
import com.van.dusty.util.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class LoginController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/LoginView");
        return mv;
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg toLogin(UserDO userDO) {
        ResultMsg result = userService.userLogin(userDO);
        return result;
    }

}
