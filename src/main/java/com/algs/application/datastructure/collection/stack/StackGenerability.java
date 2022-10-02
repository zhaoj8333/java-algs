package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;

import java.util.Objects;

/**
 *
 */
public class StackGenerability {

    /**
     * 栈中元素数量小于0，则出现下溢
     */
    public boolean isUnderflow(String[] input) {
        int count = 0;
        for (String s : input) {
            if (count < 0) {
                return true;
            }
            if ("-".equals(s)) {
                count--;
            } else {
                count++;
            }
        }
        return false;
    }

    /**
     * 两个序列值都不重复，判断是否可以在最初空栈上进行push和pop操作
     *
     * 出栈时，在他之前的数一定已经出栈（或者入栈后被弹出）
     * 入栈时，一个数x入栈时，在他之前入栈的y必须在x之后才能被弹出
     *
     * 模拟入栈与出栈过程
     * // TODO: 10/1/22  
     */
    public boolean validateStackSequence(IList<Integer> pushed, IList<Integer> popped) {
        Object[] push = pushed.toArray();
        Object[] pop  = popped.toArray();
        IStack<Integer> s = new ArrayStackImpl<>();
        int index = 0;
        for (Object val : push) {
            s.push((Integer) val);
            while (!s.isEmpty() && Objects.equals(s.top(), pop[index])) {
                s.pop();
                index++;
            }
        }
        return s.isEmpty();
    }

}
