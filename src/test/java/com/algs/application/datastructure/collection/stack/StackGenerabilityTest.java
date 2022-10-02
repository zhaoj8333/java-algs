package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.SinglyLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackGenerabilityTest {

    @Test
    void testIsUnderflow() {
        StackGenerability sg = new StackGenerability();
        String input = "- 0 1 2 3 4 5 6 7 8 9 - - - - - - - - -";
        String[] s = input.split(" ");
        boolean underflow = sg.isUnderflow(s);
        System.out.println(underflow);

        input = "0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9";
        s = input.split(" ");
        underflow = sg.isUnderflow(s);
        System.out.println(underflow);
    }

    @Test
    void testValidateStackSequence() {
        StackGenerability sg = new StackGenerability();
        int[] push = new int[] {1, 2, 3, 4, 5};
        int[] popp = new int[] {4, 5, 3, 2, 1};

        IList<Integer> pushed = new SinglyLinkedListImpl<>();
        IList<Integer> popped = new SinglyLinkedListImpl<>();
        for (int value : push) {
            pushed.add(value);
        }
        for (int value : popp) {
            popped.add(value);
        }

        boolean outputPossible = sg.validateStackSequence(pushed, popped);
        Assertions.assertTrue(outputPossible);

        popped = new SinglyLinkedListImpl<>();
        popped.add(4);
        popped.add(3);
        popped.add(5);
        popped.add(1);
        popped.add(2);

        outputPossible = sg.validateStackSequence(pushed, popped);
        Assertions.assertFalse(outputPossible);

    }
}