package com.jef.controller;

import com.jef.common.utils.BasicJspUtil;
import com.jef.constant.BasicConstant;
import com.jef.dao.IUserDao;
import com.jef.entity.User;
import com.jef.property.cache.UserCache;
import com.jef.redis.cache.ObjectCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * 测试redis的controller
 * @author Jef
 * @date 2018/11/30 10:25
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController {
    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private IUserDao userDao;

    @RequestMapping(value = "/redisIntroduce")
    public ModelAndView introduce(ModelAndView mv) {
        mv.setViewName("redis/redisIntroduce");
        return mv;
    }

    /**
     * 缓存object和取出object
     */
    @RequestMapping(value = "/object")
    public ModelAndView object(ModelAndView mv) throws Exception {
        Long userID = 1L;
        User user = UserCache.getUser(userDao, userID);
        User cacheUser = UserCache.getUser(userDao, userID);
        logger.info("设置的value是否等于获取的=" + Objects.equals(user.getName(), cacheUser.getName()));
        return BasicJspUtil.getBasicView();
    }

    /**
     * 缓存string和取出string
     */
    @RequestMapping(value = "/string")
    public ModelAndView string(ModelAndView mv) throws Exception {
        String phone = BasicConstant.EMAIL;
        ObjectCache.setCache(phone, BasicConstant.USER_NAME, BasicConstant.FIFTY_MINUTE);
        String userName = ObjectCache.getCache(phone);
        logger.info("设置的value是否等于获取的=" + Objects.equals(BasicConstant.USER_NAME, userName));
        return BasicJspUtil.getBasicView();
    }

}
