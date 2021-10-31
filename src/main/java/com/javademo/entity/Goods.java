package com.javademo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 纪念品
 */
@Data
public class Goods extends PageBean {

    private Integer id;     //主键

    private String name;    //名称

    private String shopname;  //  店铺简介

    private String des;     //商品简介

    private String coverImage;  //图片

    private BigDecimal price;   //价格

    private Integer ishot;      //是否精品

    private Integer state;      //状态

    private Date createTime;    //创建时间

    private Date updateTime;    //更新时间

    //搜索
    private String keyword;
}
