package com.jef.controller;

import com.jef.common.utils.BasicJspUtil;
import com.jef.constant.BasicConstant;
import com.jef.dao.IUserDao;
import com.jef.entity.User;
import com.jef.property.cache.UserCache;
import com.jef.redis.cache.ObjectCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private static Logger logger = LogManager.getLogger(RedisController.class);

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
    public ModelAndView object(@RequestParam(value = "userId", required = false) Long userID) throws Exception {
        if (userID == null) {
            userID = 1L;
        }
        User user = UserCache.getUser(userDao, userID);
        User cacheUser = (User)ObjectCache.getCache(User.OBJECT_KEY, String.valueOf(userID));
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
