package com.whf.springservice.dao.entity.ext;

import com.whf.springservice.dao.entity.SysRole;
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
public class SysUserRoleMember {
    private Integer roleId;
    private List<SysRoleMember> roles;
}