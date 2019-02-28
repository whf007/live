package com.whf.springservice;

import com.whf.springservice.common.vo.UserInfo;
import com.whf.springservice.model.MemberIdentity;
import com.whf.springservice.model.MemberInfo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Raden-pc on 2019/1/3.
 */
@WebService(name = "MemberFacade",
        targetNamespace = "http://springservice.whf.com")
public interface MemberFacade {
    // 用户名查询
    @WebMethod
    public MemberIdentity findOne(String identityId, String identityType);
    // 根据memberid 判断用户账号密码是否正确
    public Boolean findMember(String memberId, String password);
    // 查询会员信息
    public MemberInfo findMemberInfo(String memberId);
    // 根据memberid 判断用户账号密码是否正确
    public UserInfo findMemberDetail(UserInfo userInfo);
    // 保存用户信息
    @WebMethod
    public String saveUser(UserInfo userInfo);
}
