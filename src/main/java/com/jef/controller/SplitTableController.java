package com.jef.controller;

import com.google.common.collect.ImmutableMap;
import com.jef.dao.IOrderInfoDao;
import com.jef.dao.IOrderProductDao;
import com.jef.dao.IShopDao;
import com.jef.dao.IUserDao;
import com.jef.entity.BaseJSONVo;
import com.jef.entity.OrderInfo;
import com.jef.entity.OrderProduct;
import com.jef.entity.Shop;
import com.jef.entity.User;
import com.jef.property.cache.UserCache;
import com.jef.service.IOrderInfoService;
import com.jef.service.IUserService;
import com.jef.util.REJSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 分表controller
 *
 * @author Jef
 * @date 2021/4/3
 */
@Controller
@RequestMapping(value = "/splittable")
public class SplitTableController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IOrderInfoService orderInfoService;

    @ResponseBody
    @RequestMapping(value = "getOrderInfoListByECIDUseSplitTable", method = RequestMethod.GET)
    public BaseJSONVo getOrderInfoListByECIDUseSplitTable(@RequestParam(value = "ecID") String ecID) throws Exception {
        List<OrderInfo> orderInfoList = orderInfoService.listOrderInfo(ImmutableMap.of("ecID", ecID), -1, -1);
        return REJSONUtils.success(orderInfoList, 0, "操作成功");
    }

}