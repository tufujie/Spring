package com.jef.controller;

import com.alibaba.fastjson.JSON;
import com.jef.canvert.UserCanvert;
import com.jef.dto.ResultMsgDto;
import com.jef.dto.UserDto;
import com.jef.entity.ResultMsg;
import com.jef.entity.User;
import com.jef.service.IUserService;
import com.jef.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 登录控制
 * @author Jef
 * @dater 2018/5/15 19:18
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录请求，账号和密码必填
     * @param userDto
     * @param response
     */
    @RequestMapping("login.do")
    public void login(UserDto userDto, HttpServletResponse response) {
        User user = UserCanvert.canvertFromDto(userDto);
        if (Objects.nonNull(user)) {
            String passWord = user.getPassword();
            String encodePassWord = MD5Util.encode(passWord);
            user = userService.getByNameAndPassWord(user.getName(), encodePassWord);
            if (Objects.nonNull(user)) {
                try {
                    ResultMsgDto resultMsg = new ResultMsgDto();
                    resultMsg.setResultCode(ResultMsg.ResultCodeEnum.SUCCESS_CODE.getResultCode());
                    resultMsg.setResultMsg("登录成功");
                    resultMsg.setResultObject(user);
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().println(JSON.toJSON(resultMsg));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    ResultMsgDto resultMsg = new ResultMsgDto();
                    resultMsg.setResultCode(ResultMsg.ResultCodeEnum.ERROR_CODE.getResultCode());
                    resultMsg.setResultMsg("登录失败");
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().println(JSON.toJSON(resultMsg));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

