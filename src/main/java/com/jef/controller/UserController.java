package com.jef.controller;

import com.jef.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制
 *
 * @author Jef
 * @create 2018/5/17 16:37
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @RequestMapping(value = "/add")
    public void add(User user) {

    }

    @RequestMapping(value = "/update")
    public void update(User user) {

    }
}
