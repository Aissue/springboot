package com.example.demo.config;

import com.example.demo.utils.FileUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;


/**
 * 关闭应用时，做已下操作
 */
@Component
public class ShutDownHook implements DisposableBean{

    @Override
    public void destroy() throws Exception {
        System.out.println("springboot shutdown ...");
        FileUtil.createFile("shutdown.txt","测试一下springboot关闭了没有");
    }
}
