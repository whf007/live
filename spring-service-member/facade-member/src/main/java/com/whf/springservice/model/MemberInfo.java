package com.whf.springservice.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Raden-pc on 2019/1/20.
 */
@Data
public class MemberInfo {
    private String memberId;

    private String memberName;

    private Boolean type;

    private Integer pidId;

    private String realName;

    private String certNo;

    private String teacherType;

    private String demo;

    private String wechat;

    private String alipay;

    private String lable;

    private String password;
    private String salt;
    private Date createTime;

    private Date updateTime;

    private String status;
}