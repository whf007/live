package com.whf.springservice.common.util;

/**
 * Created by Raden-pc on 2019/2/19.
 */
public class AssertUtils {
    public static void requireTrue(boolean value, String msg) {
        if (!value) {
            throw new RuntimeException(msg);
        }
    }
}