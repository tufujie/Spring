package com.jef.controller;

import com.jef.common.utils.BasicJspUtil;
import com.jef.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 其他功能的控制器
 * @author Jef
 * @create 2018/6/11 20:36
 */
@Controller
@RequestMapping(value = "/postAll")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    /**
     * 其他功能的跳转
     * @param mv
     * @return
     */
    @RequestMapping(value = "post")
    public ModelAndView otherIntroduce(ModelAndView mv) {
        mv.setViewName("post/post");
        return mv;
    }

    /**
     * 直接用对象接收，推荐使用
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postOne", method = RequestMethod.POST)
    public ModelAndView postOne(User user) {
        return BasicJspUtil.getBasicView();
    }

    @ResponseBody
    @RequestMapping(value = "/postTwo", method = RequestMethod.POST)
    public ModelAndView postTwo(
            @RequestParam(value = "name", required=true) String name,
            @RequestParam(value = "password", required=true) String password,
            @RequestParam(value = "phone", required=true) String phone) {
        return BasicJspUtil.getBasicView();
    }

    @ResponseBody
    @RequestMapping(value = "/postThree", method = RequestMethod.POST)
    public ModelAndView postThree(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        return BasicJspUtil.getBasicView();
    }

}
