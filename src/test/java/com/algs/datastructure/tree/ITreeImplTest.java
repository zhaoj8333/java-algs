package com.algs.datastructure.tree;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.bst.AbstractBinarySearchTree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.datastructure.tree.bst.itr.*;
import com.algs.datastructure.tree.printer.BinaryTrees;
import com.algs.utils.array.ArraysUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * @see com.algs.datastructure.st.IOrderedSymbolTableImplTest
 */
class ITreeImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
//            RecursiveBinarySearchTreeImpl.class,
            BinarySearchTreeImpl.class,
    };

    private final Integer[] testArray = { 15, 11, 9, 13, 22, 14, 30, 1, 4, 10, 17, 7, 4, 5, 25, 20, 8, 3, 3, 26 };

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

    @Override
    protected void testEach(Object obj) {
        AbstractBinarySearchTree<Integer, String> tree = (AbstractBinarySearchTree<Integer, String>) obj;
        for (Integer em : testArray) {
            tree.put(em, "(" + em + ")");
        }
        Iterator<Integer> itr = tree.iterator(
//                InOrderStackIteratorImpl.class,
//                PreOrderStackIteratorImpl.class,
//                PostOrderIteratorImpl.class,
//                LevelOrderQueueIteratorImpl.class,
                PreOrderIteratorImpl.class,
//                InOrderIteratorImpl.class,
//                PostOrderIteratorImpl.class,
//                LevelOrderIteratorImpl.class,
                ele -> {
                    BstNode<Integer, String> treeNode = (BstNode<Integer, String>) ele;
                    System.out.print(treeNode.key + ", ");
                }
        );
        Assertions.assertEquals("(20)", tree.get(20));

        BinaryTrees.println(tree);

//        testMinMax(tree);

//        testIsBalanced(tree);

//        testFloorAndCeil(tree);

        testItr(tree);

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

    private void testIsBalanced(AbstractBinarySearchTree<Integer, String> tree) {
        boolean balanced = tree.isBalanced();
        Assertions.assertFalse(balanced);
    }

    private void testMinMax(AbstractBinarySearchTree<Integer, String> tree) {
        if (tree.isEmpty()) {
            Assertions.assertNull(tree.max());
            Assertions.assertNull(tree.min());
        }
        Assertions.assertEquals(1, tree.min());
        Assertions.assertEquals(30, tree.max());

    }

    private void testFloorAndCeil(AbstractBinarySearchTree<Integer, String> tree) {
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
    private void testDelete(AbstractBinarySearchTree<Integer, String> tree) {
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

    private static void testItr(AbstractBinarySearchTree<Integer, String> tree) {
        TreeIterator<Integer> itr = null;

        /**
         * pre order
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26
         */
        {
            System.out.println(PreOrderIteratorImpl.class.getSimpleName());
            itr = (TreeIterator<Integer>) tree.iterator(PreOrderStackIteratorImpl.class, null);
            Integer next = itr.next();
            Assertions.assertEquals(15, next);
            next = itr.next();
            Assertions.assertEquals(11, next);
            next = itr.next();
            Assertions.assertEquals(9, next);
            next = itr.next();
            Assertions.assertEquals(1, next);
            next = itr.next();
            Assertions.assertEquals(4, next);
            next = itr.next();
            Assertions.assertEquals(3, next);
            next = itr.next();
            Assertions.assertEquals(7, next);
            next = itr.next();
            Assertions.assertEquals(5, next);

//            itr = (TreeIterator<Integer>) tree.iterator(PreOrderStackIteratorImpl.class, null);
//            while (itr.hasNext()) {
//                next = itr.next();
//                System.out.print(next + ", ");
//            }
            System.out.println();
        }

        /**
         * in order
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26
         */
        {
            System.out.println(InOrderStackIteratorImpl.class.getSimpleName());
            itr = (TreeIterator<Integer>) tree.iterator(InOrderStackIteratorImpl.class, null);
            Integer next = itr.next();
            Assertions.assertEquals(1, next);
            next = itr.next();
            Assertions.assertEquals(3, next);
            next = itr.next();
            Assertions.assertEquals(4, next);
            next = itr.next();
            Assertions.assertEquals(5, next);
            next = itr.next();
            Assertions.assertEquals(7, next);
            next = itr.next();
            Assertions.assertEquals(8, next);
            next = itr.next();
            Assertions.assertEquals(9, next);
            next = itr.next();
            Assertions.assertEquals(10, next);
            next = itr.next();
            Assertions.assertEquals(11, next);
            next = itr.next();
            Assertions.assertEquals(13, next);
            next = itr.next();
            Assertions.assertEquals(14, next);
            next = itr.next();
            Assertions.assertEquals(15, next);

            itr = (TreeIterator<Integer>) tree.iterator(InOrderStackIteratorImpl.class, null);
//            while (itr.hasNext()) {
//                next = itr.next();
//                System.out.print(next + ", ");
//            }
            System.out.println();
        }

        /**
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26
         * post order
         * 3, 5, 8, 7, 4, 1, 10, 9, 14, 13, 11, 20, 17, 26, 25, 30, 22, 15
         */
        {
            System.out.println(PostOrderStackIteratorImpl.class.getSimpleName());
            itr = (TreeIterator<Integer>) tree.iterator(PostOrderStackIteratorImpl.class, null);
            Integer next = itr.next();
            Assertions.assertEquals(3, next);
            next = itr.next();
            Assertions.assertEquals(5, next);
            next = itr.next();
            Assertions.assertEquals(8, next);
            next = itr.next();
            Assertions.assertEquals(7, next);
            next = itr.next();
            Assertions.assertEquals(4, next);
            next = itr.next();
            Assertions.assertEquals(1, next);
            next = itr.next();
            Assertions.assertEquals(10, next);
            next = itr.next();
            Assertions.assertEquals(9, next);
            next = itr.next();
            Assertions.assertEquals(14, next);
            next = itr.next();
            Assertions.assertEquals(13, next);
            next = itr.next();
            Assertions.assertEquals(11, next);

//            while (itr.hasNext()) {
//                next = itr.next();
//                System.out.print(next + ", ");
//            }
            System.out.println();
        }
    }

    @Test
    @Override
    public void test() {
        System.out.println("Testing array: " + ArraysUtil.toString(testArray));
        System.out.println();
        test(targetClasses);
    }

}