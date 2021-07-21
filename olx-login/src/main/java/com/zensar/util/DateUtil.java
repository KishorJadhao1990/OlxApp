package com.zensar.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final String DATE_TIME_FORMAT = "yyyy-mm-dd HH:mm";

    public static String currentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    public static String currentDateTime(String format) {
        format = StringUtil.isEmpty(format) ? DATE_TIME_FORMAT : format;
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static Long currentDateTimeInMillis() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }
}
