package com.whf.springservice.dao.mapper;

import com.whf.springcloud.common.dao.CrudMapper;
import com.whf.springservice.dao.entity.SysRole;
import com.whf.springservice.dao.entity.SysRolePermission;
import com.whf.springservice.dao.entity.SysRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper extends CrudMapper<SysRolePermission> {
    public SysRolePermission selectById(Integer roleId);
}