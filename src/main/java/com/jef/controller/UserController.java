package com.jef.controller;

import com.jef.entity.User;
import com.jef.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 用户控制
 *
 * @author Jef
 * @create 2018/5/17 16:37
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/add")
    public void add(User user) {

    }

    @RequestMapping(value = "/update")
    public void update(User user) {

    }

    @ResponseBody
    @RequestMapping(value = "/gotoRegister", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mv) {
        mv.setViewName("register");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/register1", method = RequestMethod.POST)
    public ModelAndView register(
            @RequestParam(value = "name", required=true) String name,
            @RequestParam(value = "password", required=true) String password,
            @RequestParam(value = "phone", required=true) String phone,
            @RequestParam(value = "age", required=true) Integer age,
            ModelAndView mv, HttpSession session) {
        User user = userService.getByName(name);
        if (Objects.nonNull(user)) {
            mv.addObject("registerErrorMessage","用户名已存在");
            mv.setViewName("register");
        } else {
            user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setPhone(phone);
            user.setAge(age);
            userService.insert(user);
            session.setAttribute("user", user);
            mv.setViewName("homepage"); //重定向到homepage页面中
        }
        return mv;
    }


    /**
     * @param user
     * @return ModelAndView
     */
    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    public ModelAndView register2(User user, ModelAndView mv) {
        return mv;
    }


}
