package com.example.project_agriculture.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateTimeUtils {

    private static final String DATE_FORMAT_MM_DD_YYYY_HH_MM_SS = "EEE MMM dd HH:mm:ss Z yyyy";
    private static final String DATE_FORMAT_MM_DD_YYYY = "yyyy-MM-dd";
    private static final String DATE_FORMAT_HH_MM_SS = "HH:mm:ss";
    private static final String DATE_FORMAT_HH_MM = "HH:mm";
    private static final String DATE_FORMAT_MM_SS = "mm:ss";

    public static String covertToFormatMMDDYYYYHHMMSS(Long millisecond) {
        String result = null;
        try {
            Date convert = new Date(millisecond);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_MM_DD_YYYY_HH_MM_SS);
            result = format.format(convert);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    public static String covertToFormatMMDDYYYY(Long millisecond) {
        String result = null;
        try {
            Date convert = new Date(millisecond);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_MM_DD_YYYY);
            result = format.format(convert);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    public static String covertToFormatHHMMSS(Long millisecond) {
        String result = null;
        try {
            Date convert = new Date(millisecond);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_HH_MM_SS);
            result = format.format(convert);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    public static String covertToFormatHHMM(Long millisecond) {
        String result = null;
        try {
            Date convert = new Date(millisecond);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_HH_MM);
            result = format.format(convert);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    public static String covertToFormatMMSS(Long millisecond) {
        String result = null;
        try {
            Date convert = new Date(millisecond);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_MM_SS);
            result = format.format(convert);
        } catch (Exception e) {
            log.error(e.toString());
        }

        return result;
    }
}
