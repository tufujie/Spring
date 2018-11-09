package com.jef.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * GET请求类似
 * @author Jef
 * @create 2018/6/11 20:36
 */
@Controller
@RequestMapping(value = "/getAll")
public class GetController {
    private static final Logger logger = LoggerFactory.getLogger(GetController.class);

    /**
     * 其他功能的跳转
     * @param mv
     * @return
     */
    @RequestMapping(value = "get")
    public ModelAndView otherIntroduce(ModelAndView mv) {
        mv.setViewName("get/get");
        return mv;
    }



}
