package com.whf.springservice.common.resp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Raden-pc on 2019/1/5.
 */
@Getter
@Setter
@ToString
public class RegisterResp extends Response{
    private String memberId = "213";
}
