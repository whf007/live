package com.whf.springservice.common.util;

import org.apache.commons.collections.map.HashedMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Raden-pc on 2019/2/19.
 */
public class RandomNumberUtils {
    /**
     * 推荐单编号指定格式生成“每日日期+4位数字增长不重复，每天重新开始计数”
     *
     * @param currentRecordNumber//最新一条推荐单每日的排号
     * @return
     */
    public static String getRandomRecordNumber( String currentRecordNumber) {
        String recordTimeAndNumberNew = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateStr = sdf.format(date);
        recordTimeAndNumberNew = dateStr + currentRecordNumber;
        return recordTimeAndNumberNew;
    }
}