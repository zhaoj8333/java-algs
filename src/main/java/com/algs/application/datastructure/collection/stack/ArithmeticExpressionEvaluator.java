package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.queue.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.LinkedListQueueImpl0;
import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedListStackImpl;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

/**
 * Dijkstra double stack arithmetic expression evaluation
 * () * + - - /
 */
public class ArithmeticExpressionEvaluator {

    private boolean isAsciiNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }

    private boolean isDot(char ch) {
        return ch == 46;
    }

    public IQueue<Integer> getIntFromString(String string) {
        IQueue<Integer> q = new ArrayQueueImpl<>();
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
        IQueue<Double> q = new LinkedListQueueImpl0<>();
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
        IStack<String> ops = new ArrayStackImpl<>();
        IStack<Double> vals = new LinkedListStackImpl<>();

        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            StringBuilder numberString = new StringBuilder();
            while (isAsciiNumber(c) || isDot(c)) {
                numberString.append(c);
                if (i >= len - 1) {
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
                }
                vals.push(val);
            }
        }
        return vals.pop();
    }

    /**
     * 中缀表达式 左括号自动补全
     *
     * input: 1+2) * 3-4) * 5-6)))
     *        |
     *       \/
     * result: ((1+2) * ((3-4) * (5-6)))
     */
    public String autoCompleteLeftBracesOfInfixExpression(String unCompleteExpression) {
        ObjectUtil.requireNonNull(unCompleteExpression);
        if (unCompleteExpression.isBlank()) {
            return "";
        }
        IStack<String> ops = new ArrayStackImpl<>();
        IStack<Double> vals = new LinkedListStackImpl<>();

        int length = unCompleteExpression.length();
        int[] leftBracePositions = new int[length];
        for (int i = 0; i < length; i++) {
            char c = unCompleteExpression.charAt(i);
            StringBuilder numberString = new StringBuilder();
            if (isAsciiNumber(c) || isDot(c)) {
                numberString.append(c);
                ++i;
                if (i >= length - 1) {
                    break;
                }
                c = unCompleteExpression.charAt(i);
            }
            if (numberString.length() > 0) {
                vals.push(Double.parseDouble(numberString.toString()));
                int numberLen = numberString.length();

            }
            String str = String.valueOf(c);
            if (Objects.equals("(", str)) {

            } else if (Objects.equals("+", str)) {
                ops.push(str);
            } else if (Objects.equals("-", str)) {
                ops.push(str);
            } else if (Objects.equals("*", str)) {
                ops.push(str);
            } else if (Objects.equals("/", str)) {
                ops.push(str);
            } else if (Objects.equals(")", str)) {
                String op = ops.pop();
                Double val = vals.pop();
                if (Objects.equals("+", str)) {
                    val = val + vals.pop();
                } else if (Objects.equals("-", str)) {
                    val = val - vals.pop();
                } else if (Objects.equals("*", str)) {
                    val = val * vals.pop();
                } else if (Objects.equals("/", str)) {
                    val = val / vals.pop();
                }
                vals.push(val);
            }
        }
        return null;
    }

}
