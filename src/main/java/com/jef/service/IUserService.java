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

    /**
     * 新增用户
     * @param user
     * @return
     */
    User insert(User user);

    User getByName(String name);

    void updateUser(User user) throws Exception;
}
