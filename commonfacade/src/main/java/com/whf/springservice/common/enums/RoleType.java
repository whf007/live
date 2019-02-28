package com.whf.springservice.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Raden-pc on 2019/1/24.
 */
@Getter
@AllArgsConstructor
public enum RoleType {
    TEACHER(2,"teacher"),
    STUDENT(3,"student");
    final private Integer code;
    final private String msg;

    public static RoleType get(Integer code) {
        for (RoleType type : values())
            if (type.getCode().equals(code))
                return type;

        return null;
    }
}
