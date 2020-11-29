package com.jef.factory;

import com.jef.constant.BasicConstant;
import com.jef.entity.User;

/**
 * @author Jef
 * @date 2020/11/29
 */
public class UserFactory {

    private User user;

    public String createInstance() {
        return BasicConstant.USER_NAME;
    }
}