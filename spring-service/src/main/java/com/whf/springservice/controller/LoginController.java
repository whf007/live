package com.whf.springservice.controller;

import com.whf.springservice.common.Commons;
import com.whf.springservice.common.enums.LoginType;
import com.whf.springservice.common.enums.ResponseCode;
import com.whf.springservice.common.enums.RoleType;
import com.whf.springservice.common.enums.TeacherType;
import com.whf.springservice.common.resp.LoginResp;
import com.whf.springservice.common.resp.Response;
import com.whf.springservice.common.vo.Role;
import com.whf.springservice.common.vo.UserInfo;
import com.whf.springservice.config.PasswordEncry;
import com.whf.springservice.service.MemberServiceWS;
import com.whf.springservice.vo.LoginReq;
import com.whf.springservice.vo.RegisterReq;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DelegatingSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Raden-pc on 2019/1/19.
 */
@Controller
public class LoginController {
    @Autowired
    MemberServiceWS memberServiceWS;
    @PostMapping("/login")
    @ResponseBody
    public LoginResp login(HttpServletRequest request, @RequestBody LoginReq loginReq) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
		//  获取用户名和密码
        String userName = loginReq.getUsername();
        String password = loginReq.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        UserInfo user = (UserInfo) subject.getPrincipal();
        // 认证结果
        boolean result = subject.isAuthenticated();
        token.setRememberMe(true);
        System.out.println("认证结果" + result);
        subject.checkRole("admin");
        request.getSession().setAttribute(user.getMemberId(), user);
        request.getSession().setAttribute(Commons.LOGIN_ADMIN_KEY, user);
        subject.getSession().setAttribute(Commons.LOGIN_ADMIN_KEY, user);
        LoginResp loginResp = new LoginResp();
        loginResp.setMemberId(user.getMemberId());
        return loginResp;


//        String exception = (String) request.getAttribute("shiroLoginFailure");
//        System.out.println("exception=" + exception);
//        String msg = "";
//        if (exception != null) {
//        	if (UnknownAccountException.class.getName().equals(exception)) {
//        		System.out.println("UnknownAccountException -- > 账号不存在：");
//        		msg = "UnknownAccountException -- > 账号不存在：";
//        	} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//        		System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//        		msg = "IncorrectCredentialsException -- > 密码不正确：";
//        	} else if ("kaptchaValidateFailed".equals(exception)) {
//        		System.out.println("kaptchaValidateFailed -- > 验证码错误");
//        		msg = "kaptchaValidateFailed -- > 验证码错误";
//        	} else {
//        		msg = "else >> "+exception;
//        		System.out.println("else -- >" + exception);
//        	}
//        }
//        map.put("msg", msg);
//        // 此方法不处理登录成功,由shiro进行处理
//		Response response = new Response();
//        return response;
    }
    @PostMapping("/register")
    @ResponseBody
    public Response register(HttpServletRequest request,@RequestBody RegisterReq registerReq) throws Exception{
        UserInfo userInfo = new UserInfo();
        userInfo.setIdentityId(registerReq.getUsername());
        userInfo.setIdentityType(LoginType.LOGIN_NAME.getCode());
        userInfo.setMemberName(registerReq.getUsername());
        userInfo.setPassword(registerReq.getPassword());
        PasswordEncry.encrypt(userInfo);
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setId(RoleType.STUDENT.getCode());
        roleList.add(role);
        userInfo.setRoleList(roleList);
        String memberId = memberServiceWS.saveMember(userInfo);
        if(StringUtils.isNotBlank(memberId)) {
            return new Response();
        }
        Response response = new Response();
        response.setCode(ResponseCode.FAIL.getCode());
        response.setMessage("会员添加失败");
        return response;
    }
}