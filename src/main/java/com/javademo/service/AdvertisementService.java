package com.javademo.service;

import com.javademo.entity.Advertisement;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;

/**
 * 轮播图service接口
 */
public interface AdvertisementService {
    ReturnDataForLayui getList(Advertisement advertisement);
    ReturnData add(Advertisement advertisement);
    ReturnData delete(Advertisement advertisement);
    ReturnData update(Advertisement advertisement);
    ReturnData updateState(Advertisement advertisement);
}
