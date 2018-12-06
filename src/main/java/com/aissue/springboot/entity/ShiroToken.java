package com.aissue.springboot.entity;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 登录token 此处可做扩展
 * 增加属性
 *
 */
public class ShiroToken extends UsernamePasswordToken {

    public ShiroToken(String username,String password){
        super(username,password);
    }

}
