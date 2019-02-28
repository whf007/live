package com.whf.springservice.dao.entity.ext;

import com.whf.springservice.dao.entity.SysPermission;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Raden-pc on 2019/1/20.
 */
@Getter
@Setter
@ToString
public class RolePermissionMember {
    private Integer permissionId;
    private Integer roleId;
    List<SysPermission> permissions;
}