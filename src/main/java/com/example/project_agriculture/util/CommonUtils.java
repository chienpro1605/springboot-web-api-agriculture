package com.example.project_agriculture.util;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

@Slf4j
public class CommonUtils {

    /**
     * <b>Check empty for String</b>
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * <b>Checks if an array of Objects is empty or null</b>
     *
     * @param array the array to test
     * @return true if the array is empty or null
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <b>Check empty for List</b>
     *
     * @param l
     * @return
     */
    public static boolean isEmpty(List<?> l) {
        return l == null || l.isEmpty();
    }

    /**
     * <b>Check empty for HashMap</b>
     *
     * @param h
     * @return
     */
    public static boolean isEmpty(HashMap<?, ?> h) {
        return h == null || h.isEmpty();
    }

    /**
     * <b>Check empty for Long</b>
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(Long s) {
        return s == null;
    }
}
