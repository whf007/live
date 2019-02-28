package com.whf.springservice.process;

import com.whf.springservice.MemberFacade;
import com.whf.springservice.common.Processor;
import com.whf.springservice.common.annotation.RegistProcessor;
import com.whf.springservice.common.enums.ResponseCode;
import com.whf.springservice.common.req.LoginReq;
import com.whf.springservice.common.resp.RegisterResp;
import com.whf.springservice.dao.entity.TmMemberIdentity;
import com.whf.springservice.dao.mapper.SequenceMapper;
import com.whf.springservice.model.MemberIdentity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
//@CheckLogin
@RegistProcessor("query_member")
public class QueryMemberProcessor implements Processor<RegisterResp, LoginReq> {

    @Autowired
    SequenceMapper sequenceMapper;
    @Autowired
    MemberFacade memberFacade;

    @Override
    public RegisterResp process(LoginReq request) throws Exception {
        RegisterResp resp = new RegisterResp();
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        TmMemberIdentity memberIdentity = new TmMemberIdentity();
        memberIdentity.setIdentityId(request.getIdentityId());
        MemberIdentity identity = memberFacade.findOne(request.getIdentityId(), request.getIdentityType());
        if(identity!=null) {
            Boolean flag = this.memberFacade.findMember(identity.getMemberId(), request.getPassword());
            if(flag) {
                return resp;
            }
            resp.setCode(ResponseCode.FAIL.getCode());
            resp.setMessage(ResponseCode.FAIL.getMsg());
            return resp;
        }
        resp.setCode(ResponseCode.USER_NOT_EXIT.getCode());
        resp.setMessage(ResponseCode.USER_NOT_EXIT.getMsg());
        return resp;
    }

    @Override
    public void check(LoginReq request) throws Exception {

    }
}
