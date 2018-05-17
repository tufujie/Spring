package com.jef.service.impl;

import com.jef.dao.UserDaoMapper;
import com.jef.entity.User;
import com.jef.service.IUserService;
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
    private UserDaoMapper userDaoMapper;

    @Override
    public User getByNameAndPassWord(String name, String password) {
        Map<String, Object> requestParams = new HashMap();
        requestParams.put("name", name);
        requestParams.put("password", password);
        return userDaoMapper.getByNameAndPassWord(requestParams);
    }

    @Override
    public void insert(User user) {
        userDaoMapper.insert(user);
    }
}
