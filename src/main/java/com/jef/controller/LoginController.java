package com.jef.controller;

import com.alibaba.fastjson.JSON;
import com.jef.dto.ResultMsgDto;
import com.jef.entity.ResultMsg;
import com.jef.entity.User;
import com.jef.service.IUserService;
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

    @RequestMapping("login.do")
    public void login(User user, HttpServletResponse response) {
        if (Objects.nonNull(user)) {
            user = userService.getByNameAndPassWord(user.getName(), user.getPassword());
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

