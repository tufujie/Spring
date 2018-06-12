package com.jef.controller;

import com.jef.common.context.SpringContextHolder;
import com.jef.constant.BasicConstant;
import com.jef.entity.User;
import com.jef.service.impl.UserServiceImpl;
import com.jef.common.utils.ContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 其他功能的控制器
 * @author Jef
 * @create 2018/6/11 20:36
 */
@Controller
@RequestMapping(value = "/other")
public class OtherCotroller {
    private static final Logger logger = LoggerFactory.getLogger(OtherCotroller.class);

    /**
     * 其他功能的跳转
     * @param mv
     * @return
     */
    @RequestMapping(value = "otherIntroduce")
    public ModelAndView otherIntroduce(ModelAndView mv) {
        mv.setViewName("other/otherIntroduce");
        return mv;
    }

    /**
     * 使用ClassPathXmlApplicationContext获取bean实例
     */
    @RequestMapping(value = "useContext")
    public void useContext() {
        ApplicationContext context = ContextUtils.getContext();
        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        // 等效如下
        // UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        User user = userService.getByName(BasicConstant.USER_NAME);
        logger.info("用户年龄={}", user.getAge());
    }

    /**
     * 使用SpringContextHolder获取bean
     */
    @RequestMapping(value = "useSpringContextHolder")
    public void useSpringContextHolder() {
        UserServiceImpl userService = SpringContextHolder.getBean("userService");
        User user = userService.getByName(BasicConstant.USER_NAME);
        logger.info("用户年龄={}", user.getAge());
    }

}
