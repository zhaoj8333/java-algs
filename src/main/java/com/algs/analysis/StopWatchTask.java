package com.algs.analysis;

import com.algs.utils.TimeUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class StopWatchTask<E> {

    protected Object result;

    protected StringBuilder profile = new StringBuilder();

    protected long begin;

    protected long end;

    protected void beforeExec() {
        if (profile.length() > 0) {
            throw new NullPointerException("already executed, please new another instance to run");
        }
        Class<? extends StopWatchTask> klass = this.getClass();
        profile.append('\n');
        profile.append("class:").append(shorterName(klass.getSimpleName()));
        profile.append('\n');
        profile.append("parameters:");
        Field[] fields = klass.getDeclaredFields();
        for (Field field : fields) {
            profile.append(field.getName()).append(" ");
            try {
                field.setAccessible(true);
                Object value = field.get(this);
                if (Objects.isNull(value)) {
                    continue;
                }
                if (value.getClass().isArray()) {
                    String s = shorterName(value.getClass().toString());
                    profile.append("[").append(s).append("], ");
                } else {
                    String s = shorterName(String.valueOf(value));
                    if (s.length() > 200) {
                        profile.append("...").append(", ");
                    } else {
                        profile.append(s).append(", ");
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        profile.append('\n');
    }

    protected String shorterName(String name) {
        if (name.length() > 10) {
            name = name.substring(name.lastIndexOf('.') + 1);
        }
        return name;
    }

    protected void afterExec() {
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

    protected void renderStopWatchProfile() {
        String profileString = this.profile.toString();
        String[] lines = profileString.split("\n");
        List<TableLine> table = new ArrayList<>(7);
        int maxTitleDashNum = 0, maxValueDashNum = 0;
        for (String line : lines) {
            if (!Objects.equals(line.trim(), "")) {
                String[] keyVal = line.split(":");
                if (keyVal.length > 1) {
                    table.add(new TableLine(keyVal[0], keyVal[1]));
                    if (keyVal[0].length() > maxTitleDashNum) {
                        maxTitleDashNum = keyVal[0].length();
                    }
                    if (keyVal[1].length() > maxValueDashNum) {
                        maxValueDashNum = keyVal[1].length();
                    }
                }
            }
        }
        StringBuilder renderString = new StringBuilder();
        int extraDashRepeat = 2;
        appendTable(renderString, maxTitleDashNum + extraDashRepeat, maxValueDashNum + 1 + extraDashRepeat);
        for (TableLine tableLine : table) {
            appendData(
                    renderString,
                    tableLine,
                    maxTitleDashNum - tableLine.key.length() - 1 + extraDashRepeat / 2,
                    maxValueDashNum - tableLine.value.length() + extraDashRepeat / 2
            );
        }
        appendTable(renderString, maxTitleDashNum + extraDashRepeat, maxValueDashNum + 1 + extraDashRepeat);
        System.out.println(renderString);
    }

    private void appendData(StringBuilder sb, TableLine tl, int keyWidth, int valueWidth) {
        sb.append('|');
        sb.append(' ');
        String key = tl.key;
        sb.append(key);
        for (int i = 0; i < keyWidth; i++) {
            sb.append(" ");
        }
        sb.append(' ');
        sb.append('|');
        sb.append(' ');
        String value = tl.value;
        sb.append(value);
        sb.append(' ');
        for (int i = 0; i < valueWidth; i++) {
            sb.append(" ");
        }
        sb.append('|');
        sb.append('\n');
    }

    private void appendTable(StringBuilder sb, int titleSize, int valueSize) {
        sb.append('+');
        for (int i = 0; i < titleSize; i++) {
            sb.append("-");
        }
        sb.append('+');
        for (int i = 0; i < valueSize; i++) {
            sb.append("-");
        }
        sb.append("+\n");
    }

    protected abstract Object profileTask();

    public long exec(boolean print) {
        assertInput();
        if (print) {
            beforeExec();
        }
        begin = System.currentTimeMillis();

        result = profileTask();

        end = System.currentTimeMillis();
        assertResult();

        if (print) {
            afterExec();
            renderStopWatchProfile();
        }
        return end - begin;
    }

    protected abstract void assertInput();

    protected abstract void assertResult();

}
