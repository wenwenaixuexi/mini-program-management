package com.javademo.controller;

import com.javademo.util.ReturnData;
import com.javademo.util.UUIDUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 上传
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "uploadImg",method = {RequestMethod.POST})
    //@PathVariable(value="file")有前端传入
    public ReturnData uploadImg(@PathVariable(value="file") MultipartFile file, HttpServletRequest request){
        String str = file.getOriginalFilename();//图片的原始名字
        String name = UUIDUtil.getUUID()+str.substring(str.lastIndexOf("."));//通过UUIDUtil获得独一无二的名字
        String path = request.getSession().getServletContext().getRealPath("/upload")+"/"+name;//存到本地
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return ReturnData.fail("上传失败");
        }
        return ReturnData.success("upload/"+name);//使其能够在前端显示出来
    }
}
