package com.jef.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jef.constant.BasicConstant;
import com.jef.entity.User;
import com.jef.service.IUserService;
import com.jef.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jef
 * @date 2018/8/16 19:48
 */
@Controller
@RequestMapping(value = "/model")
public class ModelController {
        @Autowired
        private IUserService userService;


        @RequestMapping(value = "/modelJsp")
        public ModelAndView introduce(ModelAndView mv, Model model) {
            mv.setViewName("modelJsp");
            return mv;
        }

        /**
         * jstl语法
         * @param mv
         * @return
         */
        @RequestMapping(value = "/jstl")
        public ModelAndView jstl(ModelAndView mv, Model model) {
            String adminName = BasicConstant.USER_NAME;
            User user = userService.getByName(adminName);
            if (Objects.nonNull(user)) {
                mv.addObject("admin", Boolean.TRUE);
            }
            mv.addObject("status", "2");
            List<User> userList = userService.getAllUser();
            mv.addObject("userList", userList);
            mv.addObject("now", new Date());
            mv.addObject("money", 120000.2309);
            Map map = Maps.newHashMap();
            map.put("keyName1", "value1");
            map.put("keyName2", "value1");
            model.addAttribute("mapTest", map);
            List<String> list = Lists.newArrayList();
            list.add("listValue1");
            list.add("listValue2");
            model.addAttribute("listTest", list);
            model.addAttribute("testTest", null);
            mv.setViewName("jstl");
            return mv;
        }
}
