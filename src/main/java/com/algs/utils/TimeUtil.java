package com.algs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");

    public static String formatTimestamp(Long timestamp) {
        return fmt.format(new Date(timestamp));
    }


}
