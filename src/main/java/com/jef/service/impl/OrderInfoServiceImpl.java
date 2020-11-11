package com.jef.service.impl;

import com.jef.dao.IOrderInfoDao;
import com.jef.entity.OrderInfo;
import com.jef.service.IOrderInfoService;
import com.jef.common.interceptor.SplitTablePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 订单服务，用于N中功能的测试
 *
 * @author Jef
 * @create 2018/5/15 19:21
 */
@Service(value = "orderInfoService")
public class OrderInfoServiceImpl implements IOrderInfoService {
    @Autowired
    private IOrderInfoDao orderInfoDao;


    @Override
    public List<OrderInfo> listOrderInfo(Map<String, Object> queryMap, int startPageNum, int pageCountNum) throws Exception {
        String ecID = (String) queryMap.get("ecID");
        SplitTablePlugin.setSplitRule(ecID, new String[]{"orderInfo"});
        return orderInfoDao.listOrderInfo(queryMap);
    }
}
