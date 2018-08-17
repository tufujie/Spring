package com.jef.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jef
 * @date 2018/8/16 19:48
 */
@Controller
@RequestMapping(value = "/model")
public class ModelController {

        @RequestMapping(value = "/modelJsp")
        public ModelAndView introduce(ModelAndView mv, Model model) {
            model.addAttribute("testTest", null);
            mv.setViewName("modelJsp");
            return mv;
        }
}
