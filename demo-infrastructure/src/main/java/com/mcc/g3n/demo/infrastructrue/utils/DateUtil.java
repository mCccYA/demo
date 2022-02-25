package com.mcc.g3n.demo.infrastructrue.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author yangkai
 * @date 2021/12/17
 */
public class DateUtil {

    public static final String YMD = "yyyy-MM-dd";
    public static final String YMD2 = "yyyyMMdd";
    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    private static DateTimeFormatter ymdhmsLocal = DateTimeFormatter.ofPattern(YMD_HMS);
    private static DateTimeFormatter ymdLocal = DateTimeFormatter.ofPattern(YMD);

    private static final ThreadLocal<SimpleDateFormat> dateFormator = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    public static String getLocalDateStr(Date date, String formatter) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        String dateStr = dateTimeFormatter.format(localDateTime);
        return dateStr;
    }

    public static String formatDateStr(String date,boolean end){
        if (StringUtils.isBlank(date)) {
            return null;
        }
        if(end && StringUtils.contains(date,"00:00:00")){
            date = StringUtils.trimToEmpty(StringUtils.remove(date,"00:00:00"));
        }
        if(StringUtils.length(date) == 10){
            if(!end){
                date += " 00:00:00";
            }else {
                date += " 23:59:59";
            }
        }
        return formatLocalDateTime(parseLocalYmdHms(date));
    }

    public static LocalDateTime parseLocalYmdHms(String strDate) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }
        return LocalDateTime.parse(strDate, ymdhmsLocal);
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime == null ? "" : ymdhmsLocal.format(localDateTime);
    }

    public static String formatDateStr(String date, String sourceFormat) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern(sourceFormat);
        return LocalDate.parse(date, sdf).toString();
    }
}
