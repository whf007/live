package com.whf.springservice.process;

import com.whf.springservice.MemberFacade;
import com.whf.springservice.common.Processor;
import com.whf.springservice.common.annotation.RegistProcessor;
import com.whf.springservice.common.req.RegisterReq;
import com.whf.springservice.common.resp.RegisterResp;
import com.whf.springservice.dao.mapper.SequenceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
//@CheckLogin
@RegistProcessor("register")
public class RegisterProcessor implements Processor<RegisterResp, RegisterReq> {

    @Autowired
    SequenceMapper sequenceMapper;
    @Autowired
    MemberFacade memberFacade;
    @Override
    public RegisterResp process(RegisterReq request) throws Exception {
        RegisterResp resp = new RegisterResp();
        // 获取memberId
        String nextval = sequenceMapper.nextval();

        return resp;
    }

    @Override
    public void check(RegisterReq request) throws Exception {

    }
}
