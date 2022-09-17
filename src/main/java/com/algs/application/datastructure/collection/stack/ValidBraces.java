package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedListStackImpl;

public class ValidBraces {

    public boolean usingStringManipulation(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isBlank();
    }

    public boolean usingStack(String s) {
//        IStack<Character> stack = new ArrayStackImpl<>();
        IStack<Character> stack = new LinkedListStackImpl<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (c == ')' && left != '(') {
                    return false;
                }
                if (c == '}' && left != '{') {
                    return false;
                }
                if (c == ']' && left != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
