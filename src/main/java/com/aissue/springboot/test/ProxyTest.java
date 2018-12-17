package com.aissue.springboot.test;

import com.aissue.springboot.utils.HttpClientUtil;
import com.aissue.springboot.utils.HttpProxy;
import com.aissue.springboot.utils.LeHttpUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ProxyTest {
    @Test
    public void test1(){
        long s1 = System.currentTimeMillis();
        String result0 = HttpProxy.HttpProxy("http://192.168.40.155:8081/searchPage","pageNum=1&pageSize=10","192.168.248.130",80);
        long cust1 = System.currentTimeMillis() - s1;
        System.out.println("耗时："+cust1);
        System.out.println("proxy:"+result0);

        Map<String, String> param = new HashMap<>();
        param.put("pageNum","1");
        param.put("pageSize","10");
        long s2 = System.currentTimeMillis();
        String result1 = HttpClientUtil.sendPostForm("http://192.168.40.15:8081/searchPage",param,null);
        long cust2 = System.currentTimeMillis() - s2;
        System.out.println("耗时："+cust2);
        System.out.println("httpClient:"+result1);

        long s3 = System.currentTimeMillis();
        String result2 =  LeHttpUtil.getIntance().post("http://192.168.248.130/searchPage",param);
        long cust3 = System.currentTimeMillis() - s3;
        System.out.println("耗时："+cust3);
        System.out.println("httpClient:"+result2);

    }
}
