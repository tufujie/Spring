package com.jef.service.impl;

import com.jef.dao.IUserDao;
import com.jef.entity.User;
import com.jef.property.cache.UserCache;
import com.jef.service.IUserService;
import com.jef.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务
 *
 * @author Jef
 * @create 2018/5/15 19:21
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User getByNameAndPassWord(String name, String password) {
        Map<String, Object> requestParams = new HashMap();
        requestParams.put("name", name);
        requestParams.put("password", password);
        return userDao.getByNameAndPassWord(requestParams);
    }

    @Override
    public User insert(User user) {
        user.setPassword(MD5Util.encode(user.getPassword()));
        userDao.insert(user);
        return user;
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
        UserCache.clearCache(user.getId());
    }
}
