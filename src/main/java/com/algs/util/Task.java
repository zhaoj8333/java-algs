package com.algs.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Task {

    protected Object result;

    protected StringBuilder profile = new StringBuilder();

    protected long begin;

    protected long end;

    public StringBuilder getProfile() {
        return profile;
    }

    private void beforeExec() {
        if (profile.length() > 0) {
            throw new NullPointerException("already executed, please new another instance to run");
        }
        Class<? extends Task> klass = this.getClass();
        profile.append('\n');
        profile.append("class:").append(klass.getName());
        profile.append('\n');
        profile.append("parameters:");
        Field[] fields = klass.getDeclaredFields();
        for (Field field : fields) {
            profile.append(field.getName()).append(" ");
            try {
                field.setAccessible(true);
                Object value = field.get(this);
                if (value.getClass().isArray()) {
                    String s = value.getClass().toGenericString();
                    profile.append("[").append(s).append("], ");
                } else {
                    profile.append(value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        profile.append('\n');
    }

    private void afterExec() {
        profile.append("result:").append(result);
        profile.append('\n');
        profile.append("begin:").append(TimeUtil.formatTimestamp(begin));
        profile.append('\n');
        profile.append("end:").append(TimeUtil.formatTimestamp(end));
        profile.append('\n');
        double delta = (end - begin) / 1000.0;
        profile.append("Time consumed(seconds):").append(delta).append(" s");
        profile.append('\n');
        profile.append("Time consumed(milliseconds):").append(end - begin).append(" ms");
        profile.append('\n');
    }

    private static class TableLine {
        public String key;
        public String value;

        public TableLine(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private void renderStopWatchProfile() {
        String profileString = this.profile.toString();
        String[] lines = profileString.split("\n");
        List<TableLine> table = new ArrayList<>(7);
        int maxTitleDashNum = 0, maxValueDashNum = 0;
        for (String line : lines) {
            if (!line.isBlank()) {
                String[] keyVal = line.split(":");
                table.add(new TableLine(keyVal[0], keyVal[1]));
                if (keyVal[0].length() > maxTitleDashNum) {
                    maxTitleDashNum = keyVal[0].length();
                }
                if (keyVal[1].length() > maxValueDashNum) {
                    maxValueDashNum = keyVal[1].length();
                }
            }
        }
        StringBuilder renderString = new StringBuilder();
        int extraDashRepeat = 2;
        appendTable(renderString, maxTitleDashNum + extraDashRepeat);
        for (TableLine tableLine : table) {
            appendData(
                    renderString,
                    tableLine,
                    maxTitleDashNum - tableLine.key.length() - 1 + extraDashRepeat / 2,
                    maxValueDashNum - tableLine.value.length() + extraDashRepeat / 2
            );
        }
        appendTable(renderString, maxTitleDashNum + extraDashRepeat);
        System.out.println(renderString);
    }

    private void appendData(StringBuilder sb, TableLine tl, int keyWidth, int valueWidth) {
        sb.append('|');
        sb.append(' ');
        String key = tl.key;
        sb.append(key);
        sb.append(" ".repeat(keyWidth));
        sb.append(' ');
        sb.append('|');
        sb.append(' ');
        String value = tl.value;
        sb.append(value);
        sb.append(' ');
        sb.append(" ".repeat(valueWidth));
        sb.append('|');
        sb.append('\n');
    }

    private void appendTable(StringBuilder sb, int size) {
        sb.append('+');
        sb.append("-".repeat(size));
        sb.append('+');
        sb.append("-".repeat(size));
        sb.append("+\n");
    }

    public abstract Object profileTask();

    public final void exec() {
        beforeExec();
        begin = System.currentTimeMillis();

        result = profileTask();

        end = System.currentTimeMillis();
        afterExec();
        renderStopWatchProfile();
    };


}
