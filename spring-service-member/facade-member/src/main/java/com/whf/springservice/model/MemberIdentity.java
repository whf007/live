package com.whf.springservice.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Raden-pc on 2019/1/20.
 */
@Data
public class MemberIdentity {
    private String memberId;

    private String identityId;

    private String identityType;

    private Integer pidId;

    private String partnerId;

    private Date createTime;
}