package com.whf.springservice.vo;

import lombok.Data;

/**
 * Created by Raden-pc on 2019/1/23.
 */
@Data
public class LoginReq {
    private String username;
    private String password;
    private String memberId;
}