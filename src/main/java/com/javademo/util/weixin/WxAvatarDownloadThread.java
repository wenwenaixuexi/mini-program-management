package com.javademo.util.weixin;

import com.javademo.entity.User;
import com.javademo.mapper.UserMapper;
import com.javademo.util.ReturnData;
import com.javademo.util.TextUtils;
import com.javademo.util.http.HttpRequest;

import javax.servlet.ServletContext;

/**
 * 下载微信头像并保存到本地  多线程
 */
public class WxAvatarDownloadThread extends Thread{

    private UserMapper userMapper;
    private ServletContext servletContext;
    private String avatarUrl;
    private Long userId;

    private WxAvatarDownloadThread(){

    }

    public WxAvatarDownloadThread(UserMapper userMapper,ServletContext servletContext,String avatarUrl,Long userId){
        this.userMapper = userMapper;
        this.servletContext = servletContext;
        this.avatarUrl = avatarUrl;
        this.userId = userId;
    }

    @Override
    public void run(){
        super.run();
        //没有用户头像就不再走下面的方法了
        if(TextUtils.isEmpty(avatarUrl)){
            return;
        }
        int index = avatarUrl.lastIndexOf("/");
        avatarUrl = avatarUrl.substring(0,index+1)+ConstantUtils.AVATAR_640;    //640*640的头像
        ReturnData returnData = HttpRequest.downloadSingleFile(servletContext,avatarUrl);
        if(returnData.getCode()==ReturnData.KEY_CODE_SUCCESS){
            //更新用户头像
            User user = new User();
            user.setId(userId);
            user.setAvatarUrl(returnData.getMsg());
            userMapper.updateUserAvatarAndFlag(user);
        }
    }
}
