package com.algs.datastructure.tree;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.bst.AbstractBinarySearchTree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.datastructure.tree.bst.RecursiveBinarySearchTreeImpl;
import com.algs.datastructure.tree.bst.itr.PreOrderIteratorImpl;
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
            RecursiveBinarySearchTreeImpl.class,
            BinarySearchTreeImpl.class,
    };

    private final Integer[] testArray = { 11, 1, 4, 10, 17, 7, 4, 5, 25, 20, 8, 3, 3, 26 };

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
        while (itr.hasNext()) {
            Integer next = itr.next();
        }
        System.out.println();

        BinaryTrees.print(tree);

        Assertions.assertFalse(tree.isEmpty());
        Assertions.assertEquals(6, tree.height());
        Assertions.assertFalse(tree.isComplete());

        System.out.println();
        System.out.println("------------------------------- reverse -----------------------------");
        tree.reverse();
        BinaryTrees.print(tree);
        System.out.println();

    }

    @Test
    @Override
    public void test() {
        System.out.println("Testing array: " + ArraysUtil.toString(testArray));
        System.out.println();
        test(targetClasses);
    }
}