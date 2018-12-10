package com.aissue.springboot.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {

    /**
     * shiro拦截器
     * @param securityManager
     * @return
     */
    //@Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //SecurityManager 设置
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //登录url 设置
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功后跳转url 设置
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权跳转url 设置
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //拦截器 设置
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");

        filterChainDefinitionMap.put("/lua/*", "anon");

        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/search", "perms[search]");

        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("=====Shiro拦截器工厂类注入成功=====");
        return shiroFilterFactoryBean;
    }

    /**
     * shiro管理中心
     * @return
     */
    //@Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * 自定义身份认证realm;
     * @return
     */
    //@Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }
}
