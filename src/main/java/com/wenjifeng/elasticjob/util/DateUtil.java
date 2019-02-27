package com.wenjifeng.elasticjob.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final DateFormat tidyTimeFormat = new SimpleDateFormat("HHmmss");

    public class TimeFormater {
        public final static String yyyyMMdd = "yyyy-MM-dd";
        public static final String YYYYMMDD = "yyyyMMdd";
        public static final String HHmmss = "HHmmss";
        public static final String yyyymmddHHmmss = "yyyy-MM-dd HH:mm:ss";
    }

    public static String dateToString(Date dteValue, String strFormat) {
        if (null == dteValue) {
            return null;
        }
        SimpleDateFormat clsFormat = new SimpleDateFormat(strFormat);
        return clsFormat.format(dteValue);
    }

    public static String getHaoShiTimeMsg(long startTime) {
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        long day = time / (24 * 60 * 60 * 1000);
        long hour = time / (60 * 60 * 1000) - day * 24;
        long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long hs = (time - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return "耗时: " + day + "天" + hour + "小时 " + min + "分 " + s + "秒 " + hs + "毫秒";
    }
}
