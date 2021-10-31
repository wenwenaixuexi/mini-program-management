package com.javademo.service;

import com.javademo.entity.Orders;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;

/**
 * 订单基本信息service接口
 */
public interface OrdersService {
    ReturnDataForLayui getList(Orders orders);
    ReturnData add(Orders orders);
    ReturnData update(Orders orders);
    ReturnData updateState(Orders orders);
}
