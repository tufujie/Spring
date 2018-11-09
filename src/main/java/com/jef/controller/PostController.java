package com.jef.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jef.common.utils.BasicJspUtil;
import com.jef.constant.BasicConstant;
import com.jef.entity.OrderInfo;
import com.jef.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * POST功能的控制器，GET请求类似
 * 参数为非对象或单个参数时，可参照postIds系列，参数对象或多个时，用建议的使用方法
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
     * 直接用对象接收
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postOneMoreJSON", method = RequestMethod.POST)
    public String postOneMoreJSON(@RequestBody User user) {
        logger.info(user.getName());
        return BasicConstant.SUCCESS;
    }

    /**
     * 直接用集合接收
     * @param orderInfos
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postOneMore", method = RequestMethod.POST)
    public String postOneMore(@RequestBody OrderInfo[] orderInfos) {
        for (OrderInfo orderInfo : orderInfos) {
            logger.info(orderInfo.getExtraOrderId());
        }
        return BasicConstant.SUCCESS;
    }



    /**
     * 传递每个参数，最普遍，最常用的一种方式
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
        List<OrderInfo> orderInfoListTwo = JSONArray.parseArray(orderInfos, OrderInfo.class);
        return BasicJspUtil.getBasicView();
    }

    /**
     * 多个实体对象，使用工具类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postFive", method = RequestMethod.POST)
    public ModelAndView postFive(@RequestParam(value = "user") String userStr, @RequestParam(value = "orderInfos") String orderInfosStr) {
        User user = JSON.parseObject(userStr, User.class);
        List<OrderInfo> orderInfoListTwo = JSONArray.parseArray(orderInfosStr, OrderInfo.class);
        return BasicJspUtil.getBasicView();
    }

    /**
     * 实体对象，使用ModelAttribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postSix", method = RequestMethod.POST)
    public ModelAndView postSix(@ModelAttribute User user) {
        logger.info("test");
        return BasicJspUtil.getBasicView();
    }

    /**
     * 多个实体对象，使用ModelAttribute，无法传数组
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postSeven", method = RequestMethod.POST)
    public ModelAndView postSix(@ModelAttribute ArrayList<OrderInfo> orderInfos) {
        logger.info("test");
        return BasicJspUtil.getBasicView();
    }

    /**
     * 传递ids，前台把数组转成了String
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postIds", method = RequestMethod.POST)
    public ModelAndView postIds(
            @RequestParam(value = "ids", required=true) String ids) {
        System.out.println(ids);
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            logger.info(id);
        }
        return BasicJspUtil.getBasicView();
    }

    /**
     * 传递ids，前台把数组转成了String，后台用数组接收，方式2
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postIdsOne", method = RequestMethod.POST)
    public ModelAndView postIdsOne(
            @RequestParam(value = "ids", required=true) String[] ids) {
        for (String id : ids) {
            logger.info(id);
        }
        return BasicJspUtil.getBasicView();
    }

    /**
     * 传递ids，前台把数组转成了String，后台用集合接收，方式3
     * 推荐使用，后台接收之后容易处理
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postIdsOneMore", method = RequestMethod.POST)
    public ModelAndView postIdsOneMore(
            @RequestParam(value = "ids", required=true) ArrayList<String> ids) {
        for (String id : ids) {
            logger.info(id);
        }
        return BasicJspUtil.getBasicView();
    }

    /**
     * 用list接收前台的数组参数，ids[]中的ids是前台的key，必须加上[]，指定参数名必须以数组方式
     * 传递ids
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postIdsTwo", method = RequestMethod.POST)
    public ModelAndView postIdsTwo(
            @RequestParam(value = "ids[]", required=true) ArrayList<String> ids) {
        for (String id : ids) {
            logger.info(id);
        }
        return BasicJspUtil.getBasicView();
    }

    /**
     * 用数组接收前台的数组参数，ids[]中的ids是前台的key，必须加上[]，指定参数名必须以数组方式
     * 传递ids
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postIdsThree", method = RequestMethod.POST)
    public ModelAndView postIdsThree(
            @RequestParam(value = "ids[]", required=true) String[] ids) {
        for (String id : ids) {
            logger.info(id);
        }
        return BasicJspUtil.getBasicView();
    }

    /**
     * 前台转json传到后台转化为集合
     * @param ids
     * @return
     */
    @RequestMapping(value = "/postIdsFour", method = RequestMethod.POST)
    @ResponseBody
    public List<String> postIdsFour(@RequestBody ArrayList<String> ids) {
        for (String id : ids) {
            logger.info(id);
        }
        return ids;
    }

}
