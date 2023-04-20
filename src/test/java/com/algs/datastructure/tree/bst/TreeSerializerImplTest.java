package com.algs.datastructure.tree.bst;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.serializer.InOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serializer.LevelOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serializer.PostOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serializer.PreOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serializer.RecursiveInOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serializer.RecursivePostOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serializer.RecursivePreOrderSerializerImpl;
import com.algs.datastructure.tree.bst.serializer.BstSerializer;
import com.algs.datastructure.tree.bst.serializer.ValHandler;
import com.algs.utils.TreeUtil;
import com.algs.utils.array.ArraysUtil;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;

public class TreeSerializerImplTest<K extends Comparable<K>, V> extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
            RecursivePreOrderSerializerImpl.class,
            PreOrderSerializerImpl.class,
            RecursiveInOrderSerializerImpl.class,
            RecursivePostOrderSerializerImpl.class,
            InOrderSerializerImpl.class,
            PostOrderSerializerImpl.class,
            LevelOrderSerializerImpl.class,
    };

    protected HashMap<Class<?>, Integer[]> expectedResults;

    private final ValHandler keyHandler;

    private final ValHandler valHandler;

    private final ITree<K, V> tree;

    public TreeSerializerImplTest(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        this.tree = tree;
        this.keyHandler = keyHandler;
        this.valHandler = valHandler;
        expectedResults = new HashMap<>();
        Integer[] ints = null;
        ints = new Integer[] {15, 11, 9, 1, null, 4, 3, null, null, 7, 5, null, null, 8, null, null, 10, null, null, 13, null, 14, null, null, 22, 17, null, 20, null, null, 30, 25, null, 26, null, null, null};
        expectedResults.put(RecursivePreOrderSerializerImpl.class, ints);
        ints = new Integer[] {15, 11, 9, 1, null, 4, 3, null, null, 7, 5, null, null, 8, null, null, 10, null, null, 13, null, 14, null, null, 22, 17, null, 20, null, null, 30, 25, null, 26, null, null, null};
        expectedResults.put(PreOrderSerializerImpl.class, ints);
        ints = new Integer[] {null, 1, null, 3, null, 4, null, 5, null, 7, null, 8, null, 9, null, 10, null, 11, null, 13, null, 14, null, 15, null, 17, null, 20, null, 22, null, 25, null, 26, null, 30, null};
        expectedResults.put(RecursiveInOrderSerializerImpl.class, ints);
        ints = new Integer[] {null, 1, null, 3, null, 4, null, 5, null, 7, null, 8, null, 9, null, 10, null, 11, null, 13, null, 14, null, 15, null, 17, null, 20, null, 22, null, 25, null, 26, null, 30, null};
        expectedResults.put(InOrderSerializerImpl.class, ints);
        ints = new Integer[] {null, null, null, 3, null, null, 5, null, null, 8, 7, 4, 1, null, null, 10, 9, null, null, null, 14, 13, 11, null, null, null, 20, 17, null, null, null, 26, 25, null, 30, 22, 15};
        expectedResults.put(RecursivePostOrderSerializerImpl.class, ints);
        ints = new Integer[] {null, null, null, 3, null, null, 5, null, null, 8, 7, 4, 1, null, null, 10, 9, null, null, null, 14, 13, 11, null, null, null, 20, 17, null, null, null, 26, 25, null, 30, 22, 15};
        expectedResults.put(PostOrderSerializerImpl.class, ints);
        ints = new Integer[] {15, 11, 22, 9, 13, 17, 30, 1, 10, null, 14, null, 20, 25, null, null, 4, null, null, null, null, null, null, null, 26, 3, 7, null, null, null, null, 5, 8, null, null, null, null};
        expectedResults.put(LevelOrderSerializerImpl.class, ints);
    }

    @Override
    public void test() {
        test(targetClasses);
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(ITree.class, ValHandler.class, ValHandler.class);
            instance = constructor.newInstance(tree, keyHandler, valHandler);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void testEach(Object obj) {
        BstSerializer<Integer, String> serializer = (BstSerializer<Integer, String>) obj;
        // serialize
        System.out.println("Serializing: ");
        String serializedResult = serializer.serialize();
        String expectedResult   = ArraysUtil.toString(expectedResults.get(serializer.getClass()));
        System.out.println("\tserializedResult: " + serializedResult);
        System.out.println("\texpectedResult  : " + expectedResult);
        Assertions.assertEquals(serializedResult, expectedResult);
        // deserialize
        System.out.println("Deserializing: ");
        ITree<K, V> deserializedTree = (ITree<K, V>) serializer.deserialize(expectedResult);
        Assertions.assertTrue(TreeUtil.equals(tree, deserializedTree));
    }
}