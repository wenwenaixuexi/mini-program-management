package com.javademo.mapper;

import com.javademo.entity.Goods;

import java.util.List;

/**
 * 图书
 */
public interface GoodsMapper {
    List<Goods> getList(Goods goods);
    int add(Goods goods);
    int delete(Goods goods);
    int update(Goods goods);
    int updateState(Goods goods);
}
