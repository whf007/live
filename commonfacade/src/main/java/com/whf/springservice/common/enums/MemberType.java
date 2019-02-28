package com.whf.springservice.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Raden-pc on 2019/1/24.
 */
@Getter
@AllArgsConstructor
public enum MemberType {
    TEACHER("2","teacher"),
    STUDENT("3","student");
    final private String code;
    final private String msg;

    public static MemberType get(String code) {
        for (MemberType type : values())
            if (type.getCode().equals(code))
                return type;

        return null;
    }
}
