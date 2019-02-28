package com.whf.springservice.common.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Raden-pc on 2019/1/5.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterReq extends Request{
    private String identityId;
    private String identityType;
    private String password;
}