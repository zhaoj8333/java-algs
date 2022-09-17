package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.queue.BoundedArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.UnboundedLinkedListQueueImpl0;
import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedListStackImpl;
import com.algs.util.ObjectUtil;

import java.util.Objects;

/**
 * Dijkstra double stack arithmetic expression evaluation
 * () * + - - /
 */
public class ArithmeticExpressionEvaluator {

    IStack<String> ops = new ArrayStackImpl<>();
    IStack<Double> vals = new LinkedListStackImpl<>();

    private boolean isAsciiNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }

    private boolean isDot(char ch) {
        return ch == 46;
    }

    public IQueue<Integer> getIntFromString(String string) {
        IQueue<Integer> q = new BoundedArrayQueueImpl<>();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            StringBuilder sb = new StringBuilder();
            while (isAsciiNumber(c)) {
                sb.append(c);
                if (i + 1 >= length) {
                    break;
                }
                c = string.charAt(++i);
            }
            if (sb.length() > 0) {
                q.enque(Integer.parseInt(sb.toString()));
            }
        }
        return q;
    }

    public IQueue<Double> getDoubleFromString(String string) {
        IQueue<Double> q = new UnboundedLinkedListQueueImpl0<>();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            char c = string.charAt(i);
            while (isAsciiNumber(c) || isDot(c)) {
                sb.append(c);
                if (i + 1 >= length) {
                    break;
                }
                c = string.charAt(++i);
            }
            if (sb.length() > 0) {
                q.enque(Double.parseDouble(sb.toString()));
            }
        }
        return q;
    }

    public Double evaluate(String expression) {
        ObjectUtil.requireNonNull(expression);
        if (expression.isBlank()) {
            return 0D;
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            StringBuilder numberString = new StringBuilder();
            while (isAsciiNumber(c) || isDot(c)) {
                numberString.append(c);
                if (i >= expression.length() - 1) {
                    break;
                }
                c = expression.charAt(++i);
            }
            if (numberString.length() > 0) {
                vals.push(Double.parseDouble(numberString.toString()));
            }
            String ch = String.valueOf(c);
            if (Objects.equals("(", ch)) {

            } else if (Objects.equals("+", ch)) {
                ops.push(ch);
            } else if (Objects.equals("-", ch)) {
                ops.push(ch);
            } else if (Objects.equals("*", ch)) {
                ops.push(ch);
            } else if (Objects.equals("/", ch)) {
                ops.push(ch);
            } else if (Objects.equals("sqrt", ch)) {
                ops.push(ch);
            } else if (Objects.equals(")", ch)) {
                String op = ops.pop();
                Double val = vals.pop();
                if (Objects.equals("+", op)) {
                    val = vals.pop() + val;
                } else if (Objects.equals("-", op)) {
                    val = vals.pop() - val;
                } else if (Objects.equals("*", op)) {
                    val = vals.pop() * val;
                } else if (Objects.equals("/", op)) {
                    if (val == 0) {
                        throw new ArithmeticException("divider can't be 0");
                    }
                    val = vals.pop() / val;
                } else if (Objects.equals("sqrt", op)) {
                    val = Math.sqrt(val);
                }
                vals.push(val);
            }
        }
        return vals.pop();
    }



}
