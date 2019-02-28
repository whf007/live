package com.whf.springservice.dao.entity.ext;

import com.whf.springservice.dao.entity.SysUserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Created by Raden-pc on 2019/1/20.
 */
@Getter
@Setter
@ToString
public class MemberDetailInfo {
    private String memberId;


    private String identityId;

    private String identityType;

    private Integer pidId;

    private String partnerId;

    private Date createTime;
    private List<SysUserRoleMember> userRoleList;

    private static final long serialVersionUID = 1L;
}