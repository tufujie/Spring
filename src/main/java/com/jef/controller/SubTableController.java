package com.jef.controller;

import com.google.common.collect.Maps;
import com.jef.common.utils.BasicJspUtil;
import com.jef.dao.IUserDao;
import com.jef.entity.User;
import com.jef.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 分表
 * @author Jef
 * @date 2019/4/4
 */
@Controller
@RequestMapping(value = "/subTable")
public class SubTableController {
    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private IUserDao userDao;

    @RequestMapping(value = "/subTable")
    public ModelAndView introduce(ModelAndView mv) {
        mv.setViewName("subTable/subTable");
        return mv;
    }

    /**
     * 根据用户ID查看用户
     * 分表方式1
     */
    @RequestMapping(value = "/subUserById")
    public ModelAndView object(ModelAndView mv) throws Exception {
        Long userID = 1L;
        Map<String, Object> requestParams = Maps.newHashMap();
        requestParams.put("tabIndex", DBUtil.getTableNameByUserID(userID));
        requestParams.put("id", userID);
        User user1 = userDao.getUserByParams(requestParams);
        logger.info("id为1的用户名称=" + user1.getName());
        Long userID2 = 2L;
        Map<String, Object> requestParams2 = Maps.newHashMap();
        requestParams2.put("tabIndex", DBUtil.getTableNameByUserID(userID2));
        requestParams2.put("id", userID2);
        User user2 = userDao.getUserByParams(requestParams2);
        logger.info("id为2的用户名称=" + user2.getName());
        return BasicJspUtil.getBasicView();
    }


}