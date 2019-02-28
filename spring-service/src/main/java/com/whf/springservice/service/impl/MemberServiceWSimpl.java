package com.whf.springservice.service.impl;

import com.whf.springservice.MemberFacade;
import com.whf.springservice.common.vo.UserInfo;
import com.whf.springservice.service.MemberServiceWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Raden-pc on 2019/1/20.
 */
@Service
public class MemberServiceWSimpl implements MemberServiceWS{
    @Autowired
    private MemberFacade memberFacade;
    @Override
    public UserInfo findMember(UserInfo userInfo) {

        return memberFacade.findMemberDetail(userInfo);
    }

    @Override
    public String saveMember(UserInfo userInfo) {
        String memberId = memberFacade.saveUser(userInfo);
        return memberId;
    }
}