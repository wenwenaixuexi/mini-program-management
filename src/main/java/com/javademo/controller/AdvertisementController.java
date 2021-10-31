package com.javademo.controller;

import com.javademo.entity.Advertisement;
import com.javademo.service.AdvertisementService;
import com.javademo.util.ReturnData;
import com.javademo.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 轮播图管理控制层
 */
@Controller
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @RequestMapping("/listPage")
    public String listPage(){
        return "advertisement/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Advertisement advertisement){
        return advertisementService.getList(advertisement);
    }

    @RequestMapping("/addPage")
    public String addPage(){
        return "advertisement/add";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Advertisement advertisement){
        return advertisementService.add(advertisement);
    }

    @RequestMapping("/editPage")
    public String editPage(){
        return "advertisement/edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Advertisement advertisement){
        return advertisementService.update(advertisement);
    }

    @RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Advertisement advertisement){
        return advertisementService.updateState(advertisement);
    }

}
