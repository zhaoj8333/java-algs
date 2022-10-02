package com.algs.application.datastructure.collection.stack;

/**
 * 文本编辑器缓冲区
 */
public interface TextEditorBuffer {

    int size();

    /**
     * insert char c in the position of cursor
     */
    void insert(char c);

    /**
     * get the char of position of cursor
     */
    char delete();

    /**
     * move cursor with k position to left
     */
    void left(int k);
    /**
     * move cursor with k position to right
     */
    void right(int k);

    String getString();

}
