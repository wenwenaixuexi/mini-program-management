package com.javademo.service;

import com.javademo.entity.SysUser;
import com.javademo.util.ReturnData;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员管理的service接口
 */
public interface SysUserService {
    /**
     * 用户登录判断，返回登录是否成功的对象
     */
    public ReturnData login(SysUser user, HttpServletRequest request);
}
