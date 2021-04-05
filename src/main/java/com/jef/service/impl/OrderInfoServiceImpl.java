package com.jef.service.impl;

import com.google.common.collect.Maps;
import com.jef.annotation.NoDynamicDataSource;
import com.jef.dao.IOrderInfoDao;
import com.jef.dao.IOrderProductDao;
import com.jef.dbRouting.DbContextHolder;
import com.jef.dbRouting.annotation.Router;
import com.jef.entity.OrderInfo;
import com.jef.service.IOrderInfoService;
import com.jef.common.interceptor.SplitTablePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Resource
    private IOrderProductDao orderProductDao;

    @Router
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public List<OrderInfo> listOrderInfo(OrderInfo orderInfo, int startPageNum, int pageCountNum) throws Exception {
        return orderInfoDao.listOrderInfo(orderInfo);
    }

    @Override
    public List<OrderInfo> getByUserId(Long userID, String table) {
        return orderInfoDao.getByUserId(userID);
    }
}
