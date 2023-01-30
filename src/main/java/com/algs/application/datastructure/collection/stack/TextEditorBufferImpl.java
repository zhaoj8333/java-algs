package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;

public class TextEditorBufferImpl implements TextEditorBuffer {

    /**
     * 向左 向右 移动： 从左右栈弹出并压入另一个栈
     * 插入/删除: 左栈压入或弹出
     */
    private final IStack<Character> leftSide;
    private final IStack<Character> rightSide;

    public TextEditorBufferImpl() {
        this.leftSide = new ArrayStackImpl<>();
        this.rightSide = new LinkedStackImpl<>();
    }

    @Override
    public int size() {
        return leftSide.size() + rightSide.size();
    }

    @Override
    public void insert(char c) {
        leftSide.push(c);
    }

    @Override
    public char delete() {
        return leftSide.pop();
    }

    @Override
    public void left(int k) {
        for (int i = 0; i < k; i++) {
            rightSide.push(leftSide.pop());
        }
    }

    @Override
    public void right(int k) {
        for (int i = 0; i < k; i++) {
            leftSide.push(leftSide.pop());
        }
    }

    @Override
    public String getString() {
        while (!leftSide.isEmpty()) {
            rightSide.push(leftSide.pop());
        }
        return rightSide.toString();
    }
}
