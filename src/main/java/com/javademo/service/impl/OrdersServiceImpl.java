package com.javademo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javademo.entity.Orders;
import com.javademo.entity.OrdersDetail;
import com.javademo.mapper.OrdersDetailMapper;
import com.javademo.mapper.OrdersMapper;
import com.javademo.service.OrdersService;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;
import com.javademo.util.UUIDUtil;
import com.javademo.util.UpdateOrInsertResultDeal;
import com.javademo.util.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersDetailMapper ordersDetailMapper;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    @Override
    public ReturnDataForLayui getList(Orders orders) {
        PageHelper.startPage(orders.getPage(),orders.getLimit());
        List<Orders> list = ordersMapper.getList(orders);
        PageInfo<Orders> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list,info.getTotal());
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ReturnData add(Orders orders) {
        //获取订单编号
        String orderSn = UUIDUtil.getOrderSn();
        orders.setOrderSn(orderSn);
        int i = ordersMapper.add(orders);
        Orders dbOrders;
        if(i>0){
            Orders order_query = new Orders();
            order_query.setOrderSn(orderSn);
            dbOrders = ordersMapper.getList(order_query).get(0);
            Integer ordersId = dbOrders.getId();
            for (OrdersDetail ordersDetail:orders.getOrdersDetailList()){
                ordersDetail.setOrdersId(ordersId);
                int detail_i = ordersDetailMapper.add(ordersDetail);
                if(detail_i<=0){
                    throw new CustomerException("下单失败");
                }
            }
        }else {
            throw new CustomerException("下单失败");
        }

        return ReturnData.success(dbOrders);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ReturnData update(Orders orders) {
        int i = ordersMapper.update(orders);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(Orders orders) {
        int i = ordersMapper.updateState(orders);
        return UpdateOrInsertResultDeal.dealWith(i);
    }
}
