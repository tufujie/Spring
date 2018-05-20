package com.jef.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "jsp")
public class JspController {

    @RequestMapping(value = "/forward")
    public ModelAndView forward(ModelAndView mv) {
        mv.setViewName("jsp-forward");
        return mv;
    }

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

    @RequestMapping(value = "/putApplication")
    public ModelAndView putApplication(ModelAndView mv) {
        mv.setViewName("putApplication");
        return mv;
    }

    @RequestMapping(value = "/getApplication")
    public ModelAndView getApplication(ModelAndView mv) {
        mv.setViewName("getApplication");
        return mv;
    }
}
