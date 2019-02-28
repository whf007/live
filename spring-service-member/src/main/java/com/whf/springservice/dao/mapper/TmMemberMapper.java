package com.whf.springservice.dao.mapper;

import com.whf.springcloud.common.dao.CrudMapper;
import com.whf.springservice.dao.entity.TmMember;
import com.whf.springservice.dao.entity.TmMemberExample;
import java.util.List;

import com.whf.springservice.dao.entity.TmMemberIdentity;
import org.apache.ibatis.annotations.Param;

public interface TmMemberMapper extends  CrudMapper<TmMember>{
}