package com.van.dusty.controller;

import com.van.dusty.model.UserDO;
import com.van.dusty.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class TestController {

    @Resource
    private UserService userService;

    /**
     * rest请求访问数据库
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public int addUser(UserDO user){
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/search/{id}", produces = {"application/json;charset=UTF-8"})
    public Object selectUser(@PathVariable("id") Long id){

        return userService.selectUser(id);
    }

    /**
     * 前端测试
     * @return
     */
    @RequestMapping("/listView")
    public String listView() {
        System.out.println("listView");
        return "/test";
    }

}
