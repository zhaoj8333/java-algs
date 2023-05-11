package com.algs.issues.datastructure.tree.bst;

/**
 * {@link ../../../../../../../../../resources/images/Paper-folding.png}
 */
public class PaperFolding {

    public static void printFolds(int n) {
        System.out.print(n + ": ");
        print(1, n, true);
        System.out.println();
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
        String d = down ? "D" : "B";
        System.out.print(d + " ");
        print(i + 1, n, false);
    }

}
