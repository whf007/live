package com.whf.springservice.dao.mapper;

import com.whf.springcloud.common.dao.CrudMapper;
import com.whf.springservice.dao.entity.SysPermission;
import com.whf.springservice.dao.entity.SysRole;
import com.whf.springservice.dao.entity.SysRoleExample;
import java.util.List;

import com.whf.springservice.dao.entity.SysUserRole;
import com.whf.springservice.dao.entity.ext.RolePermissionMember;
import com.whf.springservice.dao.entity.ext.SysRoleMember;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper extends CrudMapper<SysRole> {
    public List<SysRole> queryRoleByids(List<SysUserRole> userRoles);
    public SysRoleMember queryRoleById(Integer id);
}