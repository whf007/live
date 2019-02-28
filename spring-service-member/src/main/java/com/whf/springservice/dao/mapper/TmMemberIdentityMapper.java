package com.whf.springservice.dao.mapper;

import com.whf.springcloud.common.dao.CrudMapper;
import com.whf.springservice.dao.entity.TmCourseRecord;
import com.whf.springservice.dao.entity.TmMemberIdentity;
import com.whf.springservice.dao.entity.TmMemberIdentityExample;
import java.util.List;

import com.whf.springservice.dao.entity.ext.MemberDetailInfo;
import org.apache.ibatis.annotations.Param;

public interface TmMemberIdentityMapper extends CrudMapper<TmMemberIdentity> {
    public MemberDetailInfo selectMemberDetail(TmMemberIdentity identity);
}