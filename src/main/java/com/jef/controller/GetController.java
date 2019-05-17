package com.jef.controller;

import com.google.common.collect.Lists;
import com.jef.common.utils.BasicJspUtil;
import com.jef.constant.BasicConstant;
import com.jef.entity.BaseJSONVo;
import com.jef.entity.User;
import com.jef.utils.REJSONUtils;
import com.jef.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    /**
     * 其他功能的跳转
     * @param mv
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUserList")
    public BaseJSONVo getUserList(ModelAndView mv) {
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId(1L);
        user.setName(BasicConstant.USER_NAME);
        users.add(user);
        User user2 = new User();
        user2.setId(2L);
        user2.setName(BasicConstant.USER_NAME);
        users.add(user2);
        return REJSONUtils.success(users, 0, "操作成功");
    }

    /**
     * 获取传递的参数
     * @param searchParams 请求参数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getParams", method = RequestMethod.GET)
    public ModelAndView postGetParams(
            @RequestParam(value = "searchParams", required = false) String searchParams) {
        searchParams = StringUtils.decodeURLCharset(searchParams);
        System.out.println(searchParams);
        return BasicJspUtil.getBasicView();
    }


}
