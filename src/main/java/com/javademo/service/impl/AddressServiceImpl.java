package com.javademo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javademo.entity.Address;
import com.javademo.mapper.AddressMapper;
import com.javademo.service.AddressService;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;
import com.javademo.util.UpdateOrInsertResultDeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    @Override
    public ReturnDataForLayui getList(Address address) {
        PageHelper.startPage(address.getPage(),address.getLimit());
        List<Address> list = addressMapper.getList(address);
        PageInfo<Address> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list,info.getTotal());
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ReturnData add(Address address) {
        int i = addressMapper.add(address);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ReturnData delete(Address address) {
        int i = addressMapper.delete(address);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ReturnData update(Address address) {
        int i = addressMapper.update(address);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(Address address) {
        int i = addressMapper.updateState(address);
        return UpdateOrInsertResultDeal.dealWith(i);
    }
}
