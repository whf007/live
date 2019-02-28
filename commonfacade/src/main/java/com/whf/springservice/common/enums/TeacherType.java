package com.whf.springservice.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Raden-pc on 2019/1/24.
 */
@Getter
@AllArgsConstructor
public enum TeacherType {
    TEACHER("CHEMISTRY","化学"),
    MATH("MATH","数学"),
    ENGLISH("ENGLISH","英语"),
    CHINESE("CHINESE","语文"),
    PHYSICS("PHYSICS","物理"),
    BIOLOGY("BIOLOGY","生物"),
    ;
    final private String code;
    final private String msg;

    public static TeacherType get(String code) {
        for (TeacherType type : values())
            if (type.getCode().equals(code))
                return type;

        return null;
    }
}
