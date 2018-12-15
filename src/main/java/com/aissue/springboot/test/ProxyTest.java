package com.aissue.springboot.test;

import com.aissue.springboot.utils.HttpClientUtil;
import com.aissue.springboot.utils.HttpProxy;
import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    public void test1(){
        long s1 = System.currentTimeMillis();
        HttpProxy.HttpProxy("http://192.168.79.132/hello","","192.168.79.132",80);
        long cust1 = System.currentTimeMillis() - s1;
        System.out.println("耗时："+cust1);

        long s2 = System.currentTimeMillis();
        HttpClientUtil.sendPostForm("http://192.168.79.132/hello",null,null);
        long cust2 = System.currentTimeMillis() - s2;
        System.out.println("耗时："+cust2);

    }
}
