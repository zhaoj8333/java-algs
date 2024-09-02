package com.algs.issues.datastructure.tree.bst;

import com.algs.ImplFunctionalityTest;
import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl0;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.bst.BinarySearchTree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.utils.array.ArraysUtil;
import org.junit.jupiter.api.Test;

/**
 * {@link BinarySearchTreeIssue}
 */
class BinarySearchTreeIssueTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
//            RecursiveBinarySearchTreeImpl.class,
            BinarySearchTreeImpl.class,
    };

    private final Integer[] testArray = { 15, 11, 9, 13, 22, 14, 30, 1, 4, 10, 17, 7, 4, 5, 25, 20, 8, 3, 3, 26 };

    private BinarySearchTree<Integer, String> tree;

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        tree = new BinarySearchTreeImpl<>();
        for (Integer ele : testArray) {
            tree.put(ele, String.valueOf(ele));
        }
        return new BinarySearchTreeIssue<>();
    }

    @Override
    protected Class<?>[] getConstructorParameters() {
        return new Class[0];
    }

    @Override
    protected void testEach(Object obj) {
        BinarySearchTreeIssue<Integer, String> bstApp = (BinarySearchTreeIssue<Integer, String>) obj;

        boolean validate = bstApp.validate(tree);
        int i1 = bstApp.minimalAbsoluteDifference(tree);
        int i2 = bstApp.minimalDistanceBetweenNodes(tree);

        ///////////////////////////////////////
        Integer[] integers = ArraysUtil.copyAll(testArray);
        ArrayCompareAndSwapSort<Integer> sort = new QuickSortImpl0<>(integers);
        sort.sort();
        Integer[] array = sort.getArray();
        String[] strings = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strings[i] = String.valueOf(array[i]);
        }
        BinarySearchTree<Integer, String> newBst = bstApp.convertSortedArrayToBst(strings);
        ///////////////////////////////////////

        int i = bstApp.rangeSum(tree);

        BstNode<Integer, String> ancestor = bstApp.commonAncestor();

        BstNode<Integer, String> kth = bstApp.kthLargest();

        BinarySearchTree<Integer, String> recoveredTree = bstApp.recover();
    }

}