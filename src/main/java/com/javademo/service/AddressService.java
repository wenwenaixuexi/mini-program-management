package com.javademo.service;

import com.javademo.entity.Address;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;

/**
 * 收货地址service接口
 */
public interface AddressService {
    ReturnDataForLayui getList(Address address);
    ReturnData add(Address address);
    ReturnData delete(Address address);
    ReturnData update(Address address);
    ReturnData updateState(Address address);
}
