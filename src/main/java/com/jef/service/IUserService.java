package com.jef.service;

import com.jef.entity.User;

public interface IUserService {
    /**
     * 通过用户名和密码获取用户
     * @param name
     * @param password
     * @return
     */
    User getByNameAndPassWord(String name, String password);

    void insert(User user);
}
