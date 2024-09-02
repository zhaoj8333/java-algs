package com.algs.datastructure.tree.bst;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.itr.BstIterator;
import com.algs.datastructure.tree.bst.itr.BstRecursiveIterator;
import com.algs.datastructure.tree.bst.itr.InOrderIteratorImpl;
import com.algs.datastructure.tree.bst.itr.InOrderStackIteratorImpl;
import com.algs.datastructure.tree.bst.itr.LevelOrderIteratorImpl;
import com.algs.datastructure.tree.bst.itr.LevelOrderQueueIteratorImpl;
import com.algs.datastructure.tree.bst.itr.PostOrderIteratorImpl;
import com.algs.datastructure.tree.bst.itr.PostOrderStackIteratorImpl;
import com.algs.datastructure.tree.bst.itr.PreOrderIteratorImpl;
import com.algs.datastructure.tree.bst.itr.PreOrderStackIteratorImpl;
import com.algs.datastructure.tree.bst.itr.morris.MorrisInOrderIteratorImpl;
import com.algs.datastructure.tree.bst.itr.morris.MorrisIterator;
import com.algs.datastructure.tree.bst.itr.morris.MorrisPostOrderIteratorImpl;
import com.algs.datastructure.tree.bst.itr.morris.MorrisPreOrderIteratorImpl;
import com.algs.utils.array.ArraysUtil;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;

public class TreeIteratorImplTest<K extends Comparable<K>, V> extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
//            PreOrderIteratorImpl.class,
//            InOrderIteratorImpl.class,
//            PostOrderIteratorImpl.class,
//            LevelOrderIteratorImpl.class,
//
//            PreOrderStackIteratorImpl.class,
//            InOrderStackIteratorImpl.class,
//            PostOrderStackIteratorImpl.class,
//            LevelOrderQueueIteratorImpl.class,
//
//            MorrisPreOrderIteratorImpl.class,
//            MorrisInOrderIteratorImpl.class,
            MorrisPostOrderIteratorImpl.class,
    };

    protected HashMap<Class<?>, Integer[]> expectedResults;

    private final ITree<K, V> tree;

    public TreeIteratorImplTest(ITree<K, V> tree) {
        this.tree = tree;
        expectedResults = new HashMap<>();
        final Integer[] preArray = {15, 11, 9, 1, 4, 3, 7, 5, 8, 10, 13, 14, 22, 17, 20, 30, 25, 26};
        expectedResults.put(PreOrderIteratorImpl.class, preArray);
        expectedResults.put(PreOrderStackIteratorImpl.class, preArray);
        expectedResults.put(MorrisPreOrderIteratorImpl.class, preArray);

        final Integer[] inArray = {1, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 17, 20, 22, 25, 26, 30};
        expectedResults.put(InOrderIteratorImpl.class, inArray);
        expectedResults.put(InOrderStackIteratorImpl.class, inArray);
        expectedResults.put(MorrisInOrderIteratorImpl.class, inArray);

        final Integer[] postArray = {3, 5, 8, 7, 4, 1, 10, 9, 14, 13, 11, 20, 17, 26, 25, 30, 22, 15};
        expectedResults.put(PostOrderIteratorImpl.class, postArray);
        expectedResults.put(PostOrderStackIteratorImpl.class, postArray);
        expectedResults.put(MorrisPostOrderIteratorImpl.class, postArray);

        final Integer[] levelArray = {15, 11, 22, 9, 13, 17, 30, 1, 10, 14, 20, 25, 4, 26, 3, 7, 5, 8};
        expectedResults.put(LevelOrderIteratorImpl.class, levelArray);
        expectedResults.put(LevelOrderQueueIteratorImpl.class, levelArray);
        // MorrisLevelOrderIterator // TODO: 5/5/2023  
    }

    @Override
    public void test() {
        test(targetClasses);
    }

    private IQueue<Integer> recursiveSeq = new LinkedQueueImpl<>();

    private final IVisitor visitor = new IVisitor() {
        @Override
        public void visit(Object obj) {
            recursiveSeq.enque(((BstNode<Integer, String>) obj).key);
        }
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        Class<?> superclass = targetClass.getSuperclass();
        if (superclass.equals(BstIterator.class)) {
            Object instance = null;
            try {
                Constructor<?> constructor = targetClass.getConstructor(ITree.class, IVisitor.class);
                instance = constructor.newInstance(tree, null);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
            return instance;
        }
        if (superclass.equals(BstRecursiveIterator.class) || superclass.equals(MorrisIterator.class)) {
            Object instance = null;
            try {
                Constructor<?> constructor = targetClass.getConstructor(ITree.class, IVisitor.class);
                recursiveSeq = new LinkedQueueImpl<>();
                instance = constructor.newInstance(tree, visitor);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
            return instance;
        }
        return null;
    }

    @Override
    protected Class<?>[] getConstructorParameters() {
        return null;
    }

    /**
     *      ┌─────15────┐
     *      │           │
     *   ┌─11─┐     ┌───22──┐
     *   │    │     │       │
     * ┌─9─┐  13─┐ 17─┐   ┌─30
     * │   │     │    │   │
     * 1─┐ 10    14   20 25─┐
     *   │                  │
     * ┌─4─┐                26
     * │   │
     * 3 ┌─7─┐
     *   │   │
     *   5   8
     */
    @Override
    protected void testEach(Object obj) {
        if (Objects.isNull(obj)) {
            return;
        }
        if (obj instanceof BstIterator) {
            BstIterator<Integer, String> itr = (BstIterator<Integer, String>) obj;
            Integer[] array = expectedResults.get(itr.getClass());

            IQueue<Integer> seq = new LinkedQueueImpl<>();
            while (itr.hasNext()) {
                seq.enque(itr.next());
            }
            Assertions.assertTrue(ArraysUtil.equals(array, seq));
        }
        if (obj instanceof BstRecursiveIterator) {
            BstRecursiveIterator<Integer, String> itr = (BstRecursiveIterator<Integer, String>) obj;
            Integer[] array = expectedResults.get(itr.getClass());
            itr.iterate();
            Assertions.assertTrue(ArraysUtil.equals(array, recursiveSeq));
            recursiveSeq.clear();
        }
    }

}