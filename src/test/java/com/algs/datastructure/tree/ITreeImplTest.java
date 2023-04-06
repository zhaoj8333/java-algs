package com.algs.datastructure.tree;

import com.algs.ISerializable;
import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.bst.BinarySearchTree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.datastructure.tree.bst.itr.*;
import com.algs.datastructure.tree.bst.serialize.ValHandler;
import com.algs.datastructure.tree.printer.BinaryTrees;
import com.algs.utils.TreeUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.datastructure.tree.bst.serialize.RecursivePreOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serialize.RecursiveInOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serialize.RecursivePostOrderSerializerImpl;
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

    private ValHandler keyHandler = new ValHandler() {
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

    private ValHandler valHandler = new ValHandler() {
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
//        testItr(tree);
        testSerialize(tree);
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

    private void testSerialize(BinarySearchTree<Integer, String> tree) {
        ISerializable serializer = new RecursivePreOrderSerializerImpl<Integer, String>(tree, keyHandler, valHandler);
        // serialize
        String serializedResult = serializer.serialize();
        String expectedResult = "[15,11,9,1,#,4,3,#,#,7,5,#,#,8,#,#,10,#,#,13,#,14,#,#,22,17,#,20,#,#,30,25,#,26,#,#,#,]";
        System.out.println("serialized Result: " + serializedResult);
        System.out.println("expected   Result: " + expectedResult);
        Assertions.assertEquals(serializedResult, expectedResult);
        // deserialize
        ITree<Integer, String> deserializedTree = (ITree<Integer, String>) serializer.deserialize(expectedResult);
        Assertions.assertTrue(TreeUtil.equals(tree, deserializedTree));

        serializer = new RecursiveInOrderSerializerImpl<>(tree);
        serializedResult = serializer.serialize();
        expectedResult = "[#,1,#,3,#,4,#,5,#,7,#,8,#,9,#,10,#,11,#,13,#,14,#,15,#,17,#,20,#,22,#,25,#,26,#,30,#,]";
        Assertions.assertEquals(serializedResult, expectedResult);
        deserializedTree = (ITree<Integer, String>) serializer.deserialize(expectedResult);
        Assertions.assertTrue(TreeUtil.equals(tree, deserializedTree));

        serializer = new RecursivePostOrderSerializerImpl<>(tree);
        serializedResult = serializer.serialize();
        expectedResult = "[#,#,#,3,#,#,5,#,#,8,7,4,1,#,#,10,9,#,#,#,14,13,11,#,#,#,20,17,#,#,#,26,25,#,30,22,15,]";
        Assertions.assertEquals(serializedResult, expectedResult);
        deserializedTree = (ITree<Integer, String>) serializer.deserialize(expectedResult);
        Assertions.assertTrue(TreeUtil.equals(tree, deserializedTree));

//        serializer = new PreOrderSerializerImpl<>(tree);
//        String ep = serializer.serialize();
//        Assertions.assertEquals(rep, ep);

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

    private void iterateAndAssert(BinarySearchTree<Integer, String> tree, Class<?> itrClass, Integer[] expectedSeq) {
        IQueue<Integer> seq = new LinkedQueueImpl<>();
        TreeIterator<Integer, String> itr = (TreeIterator<Integer, String>) tree.iterator(itrClass, null);
        while (itr.hasNext()) {
            seq.enque(itr.next());
        }
        Assertions.assertTrue(ArraysUtil.equals(expectedSeq, seq));
    }

    private void testItr(BinarySearchTree<Integer, String> tree) {

        /**
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26
         * {@link PreOrderStackIteratorImpl}
         * {@link PreOrderIteratorImpl}
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26,
         */
        {
            Integer[] array = {15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26};
            iterateAndAssert(tree, PreOrderStackIteratorImpl.class, array);
//            iterateAndAssert(tree, PreOrderIteratorImpl.class, array);

        }

        /**
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26
         * {@link InOrderStackIteratorImpl}
         * {@link InOrderIteratorImpl}
         * 1, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 17, 20, 22, 25, 26, 30,
         */
        {
            Integer[] array = new Integer[] {1, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 17, 20, 22, 25, 26, 30};
            iterateAndAssert(tree, InOrderStackIteratorImpl.class, array);
        }

        /**
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26
         * {@link PostOrderStackIteratorImpl}
         * {@link PostOrderIteratorImpl}
         * 3, 5, 8, 7, 4, 1, 10, 9, 14, 13, 11, 20, 17, 26, 25, 30, 22, 15
         */
        {
            Integer[] array = new Integer[] {3, 5, 8, 7, 4, 1, 10, 9, 14, 13, 11, 20, 17, 26, 25, 30, 22, 15};
            iterateAndAssert(tree, PostOrderStackIteratorImpl.class, array);
        }

        /**
         * 15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26
         * {@link LevelOrderQueueIteratorImpl}
         * 15, 11, 22, 9, 13, 17, 30, 1, 10, 14, 20, 25, 4, 26, 3, 7, 5, 8,
         */
        {
            Integer[] array = new Integer[] {15, 11, 22, 9, 13, 17, 30, 1, 10, 14, 20, 25, 4, 26, 3, 7, 5, 8};
            iterateAndAssert(tree, LevelOrderQueueIteratorImpl.class, array);
        }
    }

    @Test
    @Override
    public void test() {
        System.out.println("Testing array: " + ArraysUtil.toString(testArrays[0]));
        System.out.println();
        test(targetClasses);
    }

}