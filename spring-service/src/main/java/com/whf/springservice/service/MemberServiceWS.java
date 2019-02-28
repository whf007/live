package com.whf.springservice.service;

import com.whf.springservice.common.vo.UserInfo;

/**
 * Created by Raden-pc on 2019/1/20.
 */
public interface MemberServiceWS {
    public UserInfo findMember(UserInfo userInfo);
    public String saveMember(UserInfo userInfo);
}