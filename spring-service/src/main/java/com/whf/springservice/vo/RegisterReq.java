package com.whf.springservice.vo;

import lombok.Data;

/**
 * Created by Raden-pc on 2019/1/23.
 */
@Data
public class RegisterReq {
    private String username;
    private String password;
    private String salt;
    private String type; // 会员类型 2,老师  3学生
    private String teacher; // 教学科门

}