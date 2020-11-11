package com.jef.service;

import com.jef.entity.OrderInfo;
import java.util.List;
import java.util.Map;

public interface IOrderInfoService {

    /**
     * 查询订单列表
     * @author Jef
     * @date 2020/8/27
     * @param queryMap
     * @param startPageNum
     * @param pageCountNum
     * @return java.util.List<com.jef.entity.User>
     */
    List<OrderInfo> listOrderInfo(Map<String, Object> queryMap, int startPageNum, int pageCountNum) throws Exception;
}
