package com.whf.springservice.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Raden-pc on 2019/1/24.
 */
@Getter
@AllArgsConstructor
public enum LoginType {
    LOGIN_NAME("1","loginName"),
    MOBILE("2","mobile"),
    EMAIL("3","email");
    final private String code;
    final private String msg;

    public static LoginType get(String code) {
        for (LoginType type : values())
            if (type.getCode().equals(code))
                return type;

        return null;
    }
}
