package com.algs.datastructure.tree;

import com.algs.IJunitTestable;
import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.tree.bst.BinarySearchTree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.datastructure.tree.bst.TreeIteratorImplTest;
import com.algs.datastructure.tree.bst.TreeSerializerImplTest;
import com.algs.datastructure.tree.bst.itr.morris.MorrisPreOrderIteratorImpl;
import com.algs.datastructure.tree.bst.serializer.ValHandler;
import com.algs.datastructure.tree.printer.BinaryTrees;
import com.algs.utils.array.ArraysUtil;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @see com.algs.datastructure.st.IOrderedSymbolTableImplTest
 */
class ITreeImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
//            RecursiveBinarySearchTreeImpl.class,
            BinarySearchTreeImpl.class,
    };

    private final Integer[][] testArrays = {
            { 15, 11, 9, 13, 22, 14, 30, 1, 4, 10, 17, 7, 4, 5, 25, 20, 8, 3, 3, 26 },
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor();
            instance = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    private final ValHandler keyHandler = new ValHandler() {
        @Override
        public Integer handle(Object parameter) {
            if (parameter instanceof Integer) {
                return (Integer) parameter;
            } else if (parameter instanceof String) {
                return Integer.parseInt((String) parameter);
            }
            return Integer.valueOf(String.valueOf(parameter));
        }
    };

    private final ValHandler valHandler = new ValHandler() {
        @Override
        public String handle(Object parameter) {
            return "(" + String.valueOf(parameter) + ")";
        }
    };

    @Override
    protected void testEach(Object obj) {
        BinarySearchTree<Integer, String> tree = (BinarySearchTree<Integer, String>) obj;
        for (Integer em : testArrays[0]) {
            Integer key = (Integer) keyHandler.handle(em);
            String val = (String) valHandler.handle(em);
            tree.put(key, val);
        }
        Assertions.assertEquals("(20)", tree.get(20));

        BinaryTrees.println(tree);

//        testMinMax(tree);
//        testIsBalanced(tree);
//        testFloorAndCeil(tree);
        testItr(tree);
//        testSerializer(tree);
//        testOther(tree);
//        testDelete(tree);
//        Assertions.assertFalse(tree.isEmpty());
//        Assertions.assertEquals(6, tree.height());
//        Assertions.assertFalse(tree.isComplete());
//
//        System.out.println();
//        System.out.println("------------------------------- reverse -----------------------------");
//        tree.reverse();
//        BinaryTrees.print(tree);
//        System.out.println();

    }

    private void testItr(BinarySearchTree<Integer, String> tree) {
        IJunitTestable test = new TreeIteratorImplTest<>(tree);
        test.test();
//        testMorris(tree);
    }

    public void testMorris(BinarySearchTree<Integer, String> tree) {
        MorrisPreOrderIteratorImpl itr = new MorrisPreOrderIteratorImpl<>(tree);
        itr.iterate();
    }

    private void testSerializer(BinarySearchTree<Integer, String> tree) {
        IJunitTestable test = new TreeSerializerImplTest(tree, keyHandler, valHandler);
        test.test();
    }

    private void testOther(BinarySearchTree<Integer, String> tree) {
        Assertions.assertEquals(5, tree.maxWidth());
    }

    private void testIsBalanced(BinarySearchTree<Integer, String> tree) {
        boolean balanced = tree.isBalanced();
        Assertions.assertFalse(balanced);
    }

    private void testMinMax(BinarySearchTree<Integer, String> tree) {
        if (tree.isEmpty()) {
            Assertions.assertNull(tree.max());
            Assertions.assertNull(tree.min());
        }
        Assertions.assertEquals(1, tree.min());
        Assertions.assertEquals(30, tree.max());

    }

    private void testFloorAndCeil(BinarySearchTree<Integer, String> tree) {
        // floor
        {
            Assertions.assertEquals(15, tree.floor(15));
            Assertions.assertEquals(13, tree.floor(13));
            Assertions.assertEquals(26, tree.floor(26));
            Assertions.assertEquals(4, tree.floor(4));
        }
        {
            Assertions.assertEquals(20, tree.floor(21));
            Assertions.assertEquals(15, tree.floor(16));
            Assertions.assertEquals(1, tree.floor(3));
            Assertions.assertEquals(6, tree.floor(5));
            Assertions.assertEquals(30, tree.floor(100));
            Assertions.assertEquals(1, tree.floor(2));
            Assertions.assertNull(tree.floor(1));
            Assertions.assertNull(tree.floor(-10));
        }
        // ceil
        {
            Assertions.assertEquals(15, tree.ceil(15));
            Assertions.assertEquals(13, tree.ceil(13));
            Assertions.assertEquals(26, tree.ceil(26));
            Assertions.assertEquals(4, tree.ceil(4));
            Assertions.assertEquals(17, tree.ceil(17));
        }
        {
            Assertions.assertEquals(22, tree.ceil(21));
            Assertions.assertEquals(17, tree.ceil(16));
            Assertions.assertEquals(7, tree.ceil(6));
            Assertions.assertEquals(30, tree.ceil(100));
            Assertions.assertEquals(3, tree.ceil(1));
            Assertions.assertEquals(-100, tree.ceil(1));
            Assertions.assertNull(tree.ceil(100));
            Assertions.assertNull(tree.ceil(-10));
        }
    }

    /**
     *          ┌─────15────┐
     *          │           │
     *       ┌─11─┐     ┌───22──┐
     *       │    │     │       │
     *     ┌─9─┐  13─┐ 17─┐   ┌─30
     *     │   │     │    │   │
     *     1─┐ 10    14   20 25─┐
     *       │                  │
     *     ┌─4─┐                26
     *     │   │
     *     3 ┌─7─┐
     *       │   │
     *       5   8
     */
    private void testDelete(BinarySearchTree<Integer, String> tree) {
        Assertions.assertEquals(20, tree.size());
        tree.delete(5);
        Assertions.assertEquals(19, tree.size());
        tree.delete(26);
        Assertions.assertEquals(18, tree.size());

        tree.delete(7);
        Assertions.assertEquals(17, tree.size());

        System.out.println();

        tree.delete(15);
        Assertions.assertEquals(16, tree.size());
//        BinaryTrees.println(tree);

        tree.delete(4);
//        BinaryTrees.println(tree);
        tree.delete(3);
        BinaryTrees.println(tree);

        tree.delete(9);
        BinaryTrees.println(tree);

        tree.delete(1);
        tree.delete(8);
        tree.delete(10);
        tree.delete(9);
        tree.delete(13);
        tree.delete(20);
        tree.delete(25);
        tree.delete(30);
        tree.delete(22);
        tree.delete(11);
        tree.delete(17);
        tree.delete(14);

        System.out.println();
        System.out.println("after all deleted: ");
        BinaryTrees.println(tree);
    }

    @Test
    @Override
    public void test() {
        System.out.println("Testing array: " + ArraysUtil.toString(testArrays[0]));
        System.out.println();
        test(targetClasses);
    }

//    @Test
//    void _2_2_1() {
//        ITree<Character, String> tree = new BinarySearchTreeImpl<>();
//        String eq = "EASYQUESTION";
//        for (int i = 0; i < eq.length(); i++) {
//            char c = eq.charAt(i);
//            tree.put(c, String.valueOf(c));
//        }
//        BinaryTrees.println(tree);
//    }

}