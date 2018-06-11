package com.jef.controller;

import com.jef.constant.BasicConstant;
import com.jef.dao.UserMapper;
import com.jef.entity.User;
import com.jef.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/jsp")
public class JspController {

    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/introduce")
    public ModelAndView introduce(ModelAndView mv) {
        mv.setViewName("jspIntroduce");
        return mv;
    }

    /**
     * jsp:forward
     * @param mv
     * @return
     */
    @RequestMapping(value = "/forward")
    public ModelAndView forward(ModelAndView mv) {
        mv.setViewName("jsp-forward");
        return mv;
    }

    /**
     * jsp:include
     * @param mv
     * @return
     */
    @RequestMapping(value = "/include")
    public ModelAndView include(ModelAndView mv) {
        mv.setViewName("jsp-include");
        return mv;
    }

    @RequestMapping(value = "/useBeanSetPropertyGetProperty")
    public ModelAndView useBeanSetPropertyGetProperty(ModelAndView mv) {
        mv.setViewName("useBeanSetPropertyGetProperty");
        return mv;
    }

    /**
     * application set
     * @param mv
     * @return
     */
    @RequestMapping(value = "/putApplication")
    public ModelAndView putApplication(ModelAndView mv) {
        mv.setViewName("putApplication");
        return mv;
    }

    /**
     * application get
     * @param mv
     * @return
     */
    @RequestMapping(value = "/getApplication")
    public ModelAndView getApplication(ModelAndView mv) {
        mv.setViewName("getApplication");
        return mv;
    }

    /**
     * jstl语法
     * @param mv
     * @return
     */
    @RequestMapping(value = "/jstl")
    public ModelAndView jstl(ModelAndView mv) {
        String adminName = BasicConstant.USER_NAME;
        User user = userService.getByName(adminName);
        if (Objects.nonNull(user)) {
            mv.addObject("admin", Boolean.TRUE);
        }
        mv.addObject("status", "2");
        List<User> userList = userMapper.getAllUser();
        mv.addObject("userList", userList);
        mv.addObject("now", new Date());
        mv.addObject("money", 120000.2309);
        mv.setViewName("jstl");
        return mv;
    }
}
