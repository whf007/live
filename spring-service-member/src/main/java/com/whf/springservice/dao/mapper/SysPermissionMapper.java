package com.whf.springservice.dao.mapper;

import com.whf.springcloud.common.dao.CrudMapper;
import com.whf.springservice.dao.entity.SysPermission;
import com.whf.springservice.dao.entity.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper extends CrudMapper<SysPermission> {
    public SysPermission selectById(Integer id);
}