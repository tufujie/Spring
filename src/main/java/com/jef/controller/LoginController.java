package com.jef.controller;

import com.alibaba.fastjson.JSON;
import com.jef.canvert.UserCanvert;
import com.jef.dto.ResultMsgDto;
import com.jef.dto.UserDto;
import com.jef.entity.ResultMsg;
import com.jef.entity.User;
import com.jef.service.IUserService;
import com.jef.common.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * 登录控制
 * @author Jef
 * @dater 2018/5/15 19:18
 */
@RequestMapping(value = "/login")
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;

    /**
     * 用户登录请求，账号和密码必填
     * @param userDto
     * @param response
     */
    @RequestMapping("loginOne")
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

    @RequestMapping(value = "/loginTwo", method = RequestMethod.POST)  //处理login请求
    public ModelAndView loginTwo(String name, String password, ModelAndView mv, HttpSession session, Model model) {
        logger.info("用户名为 " + name + " 尝试登录");
        logger.debug("用户名为 " + name + " 尝试登录");
        logger.error("用户名为 " + name + " 尝试登录");
        password = MD5Util.encode(password);
        User user = userService.getByNameAndPassWord(name, password); //调用业务层方法返回一个实例对象
        if (Objects.nonNull(user)) {
            if (name.equals("Jef")) {
                user.setPermission(1);
            }
            // 登录成功之后把用户信息放入session里
            session.setAttribute("user", user);
            logger.info("用户名为 " + name + " 登录成功");
            session.setAttribute("user", user);
            model.addAttribute("userInfo", user);
            mv.setViewName("homepage"); //重定向到homepage页面中
        } else {
            logger.error("用户名为 " + name + " 尝试登录失败");
            mv.addObject("message","用户名或者密码错误，请重新输入");
            mv.setViewName("login"); //重新设置view视图页面
        }
        return mv; //返回视图
    }
}

