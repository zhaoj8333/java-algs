package com.algs.application.datastructure.tree.bst;

public class PaperFolding {

    public static void printFolds(int n) {
        print(1, n, true);
    }

    /**
     * D: dent
     * B: bulge
     */
    private static void print(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        print(i + 1, n, true);
        System.out.println(down ? "D" : "B");
        print(i + 1, n, false);
    }

}
