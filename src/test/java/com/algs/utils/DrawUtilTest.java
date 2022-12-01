package com.algs.utils;

class DrawUtilTest {

    public static void main(String[] args) {
        DrawUtil.square(.2, .8, .1);
        DrawUtil.filledSquare(.8, .8, .2);
        DrawUtil.circle(.8, .2, .2);

        DrawUtil.setPenColor(DrawUtil.BOOK_RED);
        DrawUtil.setPenRadius(.02);
        DrawUtil.arc(.8, .2, .1, 200, 45);

        // draw a blue diamond
        DrawUtil.setPenRadius();
        DrawUtil.setPenColor(DrawUtil.BOOK_BLUE);
        double[] x = { .1, .2, .3, .2 };
        double[] y = { .2, .3, .2, .1 };
        DrawUtil.filledPolygon(x, y);

        // text
        DrawUtil.setPenColor(DrawUtil.BLACK);
        DrawUtil.text(0.2, 0.5, "black text");
        DrawUtil.setPenColor(DrawUtil.WHITE);
        DrawUtil.text(0.8, 0.8, "white text");
        DrawUtil.setTitle("Test ");
    }

}