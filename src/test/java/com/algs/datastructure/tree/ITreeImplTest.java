package com.algs.datastructure.tree;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.bst.AbstractBinarySearchTree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.datastructure.tree.printer.BinaryTrees;
import com.algs.utils.array.ArraysUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * @see com.algs.datastructure.st.IOrderedSymbolTableImplTest
 */
class ITreeImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
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
        Iterator<Integer> itr = tree.preOrderIterator(obj1 -> {
            BstNode<Integer, String> treeNode = (BstNode<Integer, String>) obj1;
            System.out.print(treeNode.key + ", ");
        });
        while (itr.hasNext()) {
            Integer next = itr.next();
        }
        System.out.println();
        System.out.println();

        BinaryTrees.print(tree);
    }

    @Test
    @Override
    public void test() {
        System.out.println("Testing array: " + ArraysUtil.toString(testArray));
        System.out.println();
        test(targetClasses);
    }
}