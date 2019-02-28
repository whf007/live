package com.whf.springservice.dao.mapper;

import com.whf.springcloud.common.dao.CrudMapper;
import com.whf.springservice.dao.entity.SysRolePermission;
import com.whf.springservice.dao.entity.SysUserRole;
import com.whf.springservice.dao.entity.SysUserRoleExample;
import java.util.List;

import com.whf.springservice.dao.entity.ext.SysUserRoleMember;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper extends CrudMapper<SysUserRole> {
    public SysUserRoleMember selectUserRoleByMemberId(String memberId);
}