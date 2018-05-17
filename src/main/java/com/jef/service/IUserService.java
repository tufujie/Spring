package com.jef.service;

import com.jef.entity.User;

public interface IUserService {
    User getByNameAndPassWord(String name, String password);
}
