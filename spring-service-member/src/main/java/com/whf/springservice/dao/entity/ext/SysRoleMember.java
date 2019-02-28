package com.whf.springservice.dao.entity.ext;

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
public class SysRoleMember {
    private Integer id;

    private Boolean available;

    private String description;

    private String role;
    private List<RolePermissionMember> permissionMembers;
}