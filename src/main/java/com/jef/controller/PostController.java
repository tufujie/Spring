package com.jef.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jef.common.utils.BasicJspUtil;
import com.jef.entity.OrderInfo;
import com.jef.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 其他功能的控制器
 * @author Jef
 * @create 2018/6/11 20:36
 */
@Controller
@RequestMapping(value = "/postAll")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    /**
     * 其他功能的跳转
     * @param mv
     * @return
     */
    @RequestMapping(value = "post")
    public ModelAndView otherIntroduce(ModelAndView mv) {
        mv.setViewName("post/post");
        return mv;
    }

    /**
     * 直接用对象接收，推荐使用
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postOne", method = RequestMethod.POST)
    public ModelAndView postOne(User user) {
        return BasicJspUtil.getBasicView();
    }

    /**
     * 传递每个参数
     * @param name
     * @param password
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postTwo", method = RequestMethod.POST)
    public ModelAndView postTwo(
            @RequestParam(value = "name", required=true) String name,
            @RequestParam(value = "password", required=true) String password,
            @RequestParam(value = "phone", required=true) String phone) {
        return BasicJspUtil.getBasicView();
    }

    /**
     * 传统使用
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postThree", method = RequestMethod.POST)
    public ModelAndView postThree(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        return BasicJspUtil.getBasicView();
    }

    /**
     * 使用工具类转，强大，推荐使用
     * @param allData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postFour", method = RequestMethod.POST)
    public ModelAndView postFour(@RequestParam(value = "allData") String allData) {
        // 方式1
        /*JSONObject object = JSONObject.fromObject(allData);
        Gson gson = new Gson();
        String userObj = object.getString("user");
        String orderInfos = object.getString("orderInfos");
        User user = gson.fromJson(userObj, new TypeToken<User>(){}.getType());
        List<OrderInfo> orderInfoList = gson.fromJson(orderInfos, new TypeToken<ArrayList<OrderInfo>>(){}.getType());*/
        // 方式2，推荐使用
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(allData);
        String userObj = object.getString("user");
        String orderInfos = object.getString("orderInfos");
        User user = JSON.parseObject(userObj, User.class);
        List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>(JSONArray.parseArray(orderInfos, OrderInfo.class));
        return BasicJspUtil.getBasicView();
    }

}
