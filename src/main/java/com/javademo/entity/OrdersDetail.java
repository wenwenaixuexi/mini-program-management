package com.javademo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情
 */
@Data
public class OrdersDetail extends PageBean {
    private Integer id;

    private Integer goodsId;

    private String name;

    private String coverImage;  //图片地址

    private Integer ordersId;   //订单编号

    private Integer num;        //购买数量

    private BigDecimal price;   //纪念品价格

    private Date createTime;    //创建时间

    private Date updateTime;    //更新时间
}
