package com.algs.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TimeUtil {

    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public static String formatTimestamp(Long timestamp) {
        return fmt.format(new Date(timestamp));
    }

    public interface Task {
        void exec();
    }

    public static void check(String title, Task task) {
        if (Objects.isNull(task)) {
            return;
        }
        title = (Objects.isNull(title) ? "" : ("[" + title + "]"));
        System.out.println(title);
        System.out.println("begin: " + fmt.format(new Date()));
        long begin = System.currentTimeMillis();
        task.exec();
        long end = System.currentTimeMillis();
        System.out.println("end : " + fmt.format(new Date()));
        double delta = (end - begin) / 1000.0;
        System.out.println("Time consumed in seconds: " + delta + " s");
        System.out.println("Time consumed in miliseconds: " + (end - begin) + " ms");
        System.out.println("------------------------------------");

    }

}
