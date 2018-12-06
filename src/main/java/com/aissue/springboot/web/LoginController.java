package com.aissue.springboot.web;

import com.aissue.springboot.entity.ShiroToken;
import com.aissue.springboot.entity.Student;
import com.aissue.springboot.service.StudentService;
import com.aissue.springboot.utils.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private static final Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public StudentService studentService;

    @RequestMapping("/login")
    public Map login(){
        Map<String,Object> map = new HashMap<>();
        ShiroToken shiroToken = new ShiroToken("aissue","123456");
        Subject currentUser = SecurityUtils.getSubject();

        Session session = currentUser.getSession();
        String ip = session.getHost();
        //设置30分钟失效
        session.setTimeout(1000*60*30);
        logger.info("====登录IP:"+ip);

        String errInfo = "successful";
        String errMsg = "登录成功";
        try{
            currentUser.login(shiroToken);
        }catch (UnknownAccountException uae) {
            errInfo = "usererror";// 用户名或密码有误
            errMsg = "用户名或密码有误";
            logger.error(errMsg);
        } catch (IncorrectCredentialsException ice) {
            errInfo = "usererror"; // 密码错误
            errMsg = "密码错误";
            logger.error(errMsg);
        }  catch (ExcessiveAttemptsException eae) {
            errInfo = "attemptserror";// 错误次数过多
            errMsg = "错误次数过多";
            logger.error(errMsg);
        } catch (LockedAccountException lr){
            errInfo = "usererror";
            errMsg = "您的账号暂时无法使用，请联系管理员处理";
            logger.error(errMsg);
        } catch (DisabledAccountException re) {
            errInfo = "usererror";
            errMsg = "您的账号已被冻结，请稍后重试";
            logger.error(errMsg);
        } catch (AuthenticationException ae) {
            errInfo = "usererror";// 验证未通过
            errMsg = "请求IP不在白名单内";
            logger.error(errMsg,ae);
        }
        map.put("result", errInfo);
        map.put("errMsg", errMsg);
        return map;
    }
}
