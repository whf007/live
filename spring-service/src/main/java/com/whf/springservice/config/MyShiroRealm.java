package com.whf.springservice.config;

import com.whf.springservice.common.req.RegisterReq;
import com.whf.springservice.common.req.Request;
import com.whf.springservice.common.vo.SysPermissionInfo;
import com.whf.springservice.common.vo.Role;
import com.whf.springservice.common.vo.UserInfo;
import com.whf.springservice.service.MemberServiceWS;
import jdk.nashorn.internal.parser.Token;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    // 注入Feign接口
//    @Autowired
//    private ServiceProviderConsumerFeignService feignService;
//    @Autowired
//    private MemberService memberService;

    @Autowired
    private MemberServiceWS memberServiceWS;
    @Autowired
    private HashedCredentialsMatcher hashedCredentialsMatcher;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
        for(Role role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermissionInfo p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        UserInfo userInfo = new UserInfo();
        if(token instanceof UsernamePasswordToken) {
            UsernamePasswordToken usernameToken = (UsernamePasswordToken)token;

            userInfo.setIdentityId(username);
            userInfo.setIdentityType("1");
            if(username == null ) {
                return null;
            }
            userInfo.setPassword(String.valueOf(usernameToken.getPassword()));
            userInfo = memberServiceWS.findMember(userInfo);
        }
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法

//        userInfo.setMemberName("管理员");
//        userInfo.setIdentityId("admin");
//        userInfo.setPassword("d3c59d25033dbf980d29554025c23a75");
//        userInfo.setPassword("123456");
//        userInfo.setSalt("8d78869f470951332959580424d4bf4f");
//        PasswordEncry.encrypt(userInfo);
//        List<Role> roles = new ArrayList<>();
//        Role role = new Role();
//        role.setRole("admin");
//        role.setAvailable(true);
//        roles.add(role);
//        userInfo.setRoleList(roles);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
//        PrincipalCollection principals = authenticationInfo.getPrincipals();
//        // 调用权限接口
//        this.doGetAuthorizationInfo(principals);
        return authenticationInfo;
    }

}