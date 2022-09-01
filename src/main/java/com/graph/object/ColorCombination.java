package com.graph.object;

import java.awt.*;

public enum ColorCombination {

    GRAY("Gray", Color.DARK_GRAY, Color.LIGHT_GRAY, Color.BLACK),
    BLUE("Blue", Color.BLUE, Color.CYAN, Color.BLACK);

    public final String name;
    public final Color borderColor;
    public final Color backgroundColor;
    public final Color lineColor;

    ColorCombination(String name, Color borderColor, Color backgroundColor, Color lineColor) {
        this.name = name;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
    }

}
