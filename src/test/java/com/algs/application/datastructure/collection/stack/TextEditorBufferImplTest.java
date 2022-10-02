package com.algs.application.datastructure.collection.stack;

import org.junit.jupiter.api.Test;

class TextEditorBufferImplTest {

    @Test
    void test() {
        TextEditorBuffer teb = new TextEditorBufferImpl();
        String s = "hello, world";
        for (int i = 0; i < s.length(); i++) {
            teb.insert(s.charAt(i));
        }
        teb.left(6);

    }

    @Test
    void size() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void left() {
    }

    /**
     * 输出缓冲区内容，光标重置到最左端
     */
    @Test
    void right() {
    }
}