package com.whf.springservice.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Raden-pc on 2018/12/23.
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(0, "操作成功"),
    FAIL(-1, "操作失败"),
    ILLEGAL_SERVICE(1,"服务不存在"),
    ILLEGAL_ARGUMENT(2,"参数错误"),
    MOBILE_FORMAT_ERROR(3,"手机号格式错误"),
    PASSWORD_ERROR(4,"密码错误"),
    USER_NOT_EXIT(5,"用户不存在"),
    USER_NOT_LOGIN(6,"用户未登录"),
    SYSTEM_ERROR(10000,"系统错误"),;
    final private Integer code;
    final private String msg;

    public static ResponseCode get(Integer code) {
        for (ResponseCode responseCode : values())
            if (responseCode.getCode().equals(code))
                return responseCode;

        return null;
    }
}