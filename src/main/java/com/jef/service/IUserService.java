package com.jef.service;

import com.jef.entity.EnterpriseVo;
import com.jef.entity.User;

import java.util.List;
import java.util.Map;

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

    List<User> getAllUser();

    /**
     * 新增用户
     * @param user 用户信息
     * @return 用户信息
     */
    User insertSubUser(User user);

    /**
     * 获取最大的用户ID
     * @return 最大的用户ID
     */
    Long getMaxUserID();

    List<User> getUserList(Map<String, Object> requestParams);
}
