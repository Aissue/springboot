package com.aissue.springboot.config;

import com.aissue.springboot.entity.ShiroToken;
import com.aissue.springboot.entity.SysPermission;
import com.aissue.springboot.entity.SysRole;
import com.aissue.springboot.entity.UserInfo;
import com.aissue.springboot.utils.JsonUtil;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger logger= LoggerFactory.getLogger(MyShiroRealm.class);

    /**
     * 授权管理
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("========myShiroRealm，授权管理========");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        logger.info("========授权："+ JsonUtil.obj2String(principalCollection));
        authorizationInfo.addRole("admin");
        authorizationInfo.addStringPermission("search");
//        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();
        /*UserInfo userInfo = new UserInfo();
        List<SysRole> roleList = new ArrayList<>();
        SysRole sysRole = new SysRole();
        sysRole.setRole();
        roleList.add()
        userInfo.setRoleList();
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }*/
        return authorizationInfo;
    }

    /**
     * 身份认证
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("========myShiroRealm，身份验证========");
        ShiroToken token = (ShiroToken) authcToken;

        // 先去表里查找此用户
        String userName = token.getUsername();
        String password = String.valueOf(token.getPassword());

        logger.info("username:"+userName+"||password:"+password);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,password,getName());

        return info;
    }
}
