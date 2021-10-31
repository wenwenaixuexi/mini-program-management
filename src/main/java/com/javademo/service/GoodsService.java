package com.javademo.service;

import com.javademo.entity.Goods;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;

/**
 * 图书service接口
 */
public interface GoodsService {
    ReturnDataForLayui getList(Goods goods);
    ReturnData add(Goods goods);
    ReturnData delete(Goods goods);
    ReturnData update(Goods goods);
    ReturnData updateState(Goods goods);
}
