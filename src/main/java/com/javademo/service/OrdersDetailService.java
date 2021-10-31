package com.javademo.service;

import com.javademo.entity.OrdersDetail;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;

/**
 * 订单详情service接口
 */
public interface OrdersDetailService {
    ReturnDataForLayui getList(OrdersDetail ordersDetail);
    ReturnData add(OrdersDetail ordersDetail);
    ReturnData update(OrdersDetail ordersDetail);
}
