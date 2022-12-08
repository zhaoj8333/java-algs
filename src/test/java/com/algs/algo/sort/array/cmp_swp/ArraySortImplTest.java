package com.algs.algo.sort.array.cmp_swp;

import com.algs.algo.sort.ISortable;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortBuOptmImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.array.ArrayGenerator;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import com.graph.analysis.algo.sort.ShellSortAlysImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Comparator;

public class ArraySortImplTest {

    @Test
    void test() {
        IList<Character> chars = FileUtil.readChars(FilePath.TINY_TXT);
        Assertions.assertNotNull(chars);

        Class<?>[] klasses = new Class<?>[] {
//                SelectionSortImpl.class,
//                HeapSortImpl.class,
//                BubbleSortImpl.class,
//                InsertionSortImpl.class,
//                SentinelInsertionSortImpl.class
//                ShellSortImpl.class,
//                MergeSortTdImpl.class,
//                MergeSortBuImpl.class,
//                MergeSortTdOptmImpl.class,
                MergeSortBuOptmImpl.class,

//                QuickSortImpl.class,
//                QuickSortImpl0.class,
//                QuickSort3wayImpl.class,

        };
        for (Class<?> klass : klasses) {
            System.out.println(klass.getSimpleName());
            functioning(klass, chars);
            System.out.println("---------------------------------");
        }
    }

    private void functioning(Class<?> sortKlass, IList<Character> characters) {
        int index = 0;
        Character[] array = new Character[characters.size()];
        Iterator<Character> itr = characters.iterator();
        while (itr.hasNext()) {
            array[index++] = itr.next();
        }
        ArraysUtil.display(array);
        Character[] original = ArraysUtil.copy(array);

        Assertions.assertTrue(array.length > 1);

        Constructor<?> constructor;
        ISortable<Character> sort = null;
        Comparator<Character> cmp = null;
        try {
            constructor = sortKlass.getConstructor(Comparable[].class, Comparator.class);
//            Comparator<Character> cmp = Comparator.comparingInt(a -> a);
            cmp = Comparator.comparingInt(a -> a);
            sort = (ISortable<Character>) constructor.newInstance(array, cmp);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        assert sort != null;
        sort.sort();
        ArraysUtil.display(array);
        Assertions.assertTrue(ArraySortUtil.isSorted(array, cmp));
        Assertions.assertTrue(ArraySortUtil.onlySorted(original, array));
    }

    private Character[] getChars() {
        String str = "EASYSORTQUESTION";
        System.out.println(str);
        Character[] chars = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    /**
     * E A S Y S O R T Q U E S T I O N
     */
    @Test
    void _2_1_9() {
        Character[] chars = getChars();
//        insertionSortAndPrintTrack(chars);
//        selectionSortAndPrintTrack(chars);
        shellSortAndPrintTrack(chars);
        Assertions.assertTrue(ArraySortUtil.isSorted(chars));

    }

    /**
     * {E, A, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     * {E, A, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     * {E, A, N, Y, S, O, R, T, Q, U, E, S, T, I, O, S}
     * {E, A, N, Y, S, O, R, T, Q, U, E, S, T, I, O, S}
     * {E, A, N, Y, S, O, R, T, Q, U, E, S, T, I, O, S}
     * {E, A, N, Y, S, O, R, T, Q, U, E, S, T, I, O, S}
     * {E, A, N, T, S, O, R, Y, Q, U, E, S, T, I, O, S}
     * {E, A, N, T, Q, O, R, Y, S, U, E, S, T, I, O, S}
     * {E, A, N, T, Q, O, R, Y, S, U, E, S, T, I, O, S}
     * {E, A, E, T, Q, O, N, Y, S, U, R, S, T, I, O, S}
     * {E, A, E, S, Q, O, N, T, S, U, R, Y, T, I, O, S}
     * {E, A, E, S, Q, O, N, T, S, U, R, Y, T, I, O, S}
     * {E, A, E, S, Q, I, N, T, S, O, R, Y, T, U, O, S}
     * {E, A, E, S, Q, I, N, T, S, O, O, Y, T, U, R, S}
     * {E, A, E, S, Q, I, N, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, S, Q, I, N, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, S, Q, I, N, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, S, Q, I, N, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, Q, S, I, N, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, I, Q, S, N, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, I, N, Q, S, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, I, N, Q, S, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, I, N, Q, S, S, S, O, O, T, T, U, R, Y}
     * {A, E, E, I, N, O, Q, S, S, S, O, T, T, U, R, Y}
     * {A, E, E, I, N, O, O, Q, S, S, S, T, T, U, R, Y}
     * {A, E, E, I, N, O, O, Q, S, S, S, T, T, U, R, Y}
     * {A, E, E, I, N, O, O, Q, S, S, S, T, T, U, R, Y}
     * {A, E, E, I, N, O, O, Q, S, S, S, T, T, U, R, Y}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, U, Y}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, U, Y}
     */
    private void shellSortAndPrintTrack(Character[] array) {
        int h = getH(array);
        int len = array.length;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int index = i;
                Character tmp = array[index];
                while ((index - h) >= 0 && tmp < array[index - h]) {
                    array[index] = array[index - h];
                    index -= h;
                }
                array[index] = tmp;
                System.out.println(ArraysUtil.toString(array));
            }
            h = h / 3;
        }
    }

    private int getH(Character[] array) {
        int len = array.length;
        System.out.println("len: " + len);
        int h = 1;
        // h: 1, 4, 13, 40, 121, 364, 1093
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        return h;
    }

    /**
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     * {A, E, S, S, Y, O, R, T, Q, U, E, S, T, I, O, N}
     * {A, E, O, S, S, Y, R, T, Q, U, E, S, T, I, O, N}
     * {A, E, O, R, S, S, Y, T, Q, U, E, S, T, I, O, N}
     * {A, E, O, R, S, S, T, Y, Q, U, E, S, T, I, O, N}
     * {A, E, O, Q, R, S, S, T, Y, U, E, S, T, I, O, N}
     * {A, E, O, Q, R, S, S, T, U, Y, E, S, T, I, O, N}
     * {A, E, E, O, Q, R, S, S, T, U, Y, S, T, I, O, N}
     * {A, E, E, O, Q, R, S, S, S, T, U, Y, T, I, O, N}
     * {A, E, E, O, Q, R, S, S, S, T, T, U, Y, I, O, N}
     * {A, E, E, I, O, Q, R, S, S, S, T, T, U, Y, O, N}
     * {A, E, E, I, O, O, Q, R, S, S, S, T, T, U, Y, N}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, U, Y}
     */
    private void insertionSortAndPrintTrack(Character[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int index = i;
            Character tmp = array[index];
            while (index > 0 && tmp < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = tmp;
            System.out.println(ArraysUtil.toString(array));
        }
    }

    /**
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     * {A, E, E, Y, S, O, R, T, Q, U, S, S, T, I, O, N}
     * {A, E, E, I, S, O, R, T, Q, U, S, S, T, Y, O, N}
     * {A, E, E, I, N, O, R, T, Q, U, S, S, T, Y, O, S}
     * {A, E, E, I, N, O, R, T, Q, U, S, S, T, Y, O, S}
     * {A, E, E, I, N, O, O, T, Q, U, S, S, T, Y, R, S}
     * {A, E, E, I, N, O, O, Q, T, U, S, S, T, Y, R, S}
     * {A, E, E, I, N, O, O, Q, R, U, S, S, T, Y, T, S}
     * {A, E, E, I, N, O, O, Q, R, S, U, S, T, Y, T, S}
     * {A, E, E, I, N, O, O, Q, R, S, S, U, T, Y, T, S}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, Y, T, U}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, Y, T, U}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, Y, U}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, U, Y}
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, U, Y}
     */
    private void selectionSortAndPrintTrack(Character[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            Character tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
            System.out.println(ArraysUtil.toString(array));
        }
    }

    @Test
    void _2_1_10() {
        Character[] array = getChars();
        hSortedOnSelectionSort(array);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * {@link InsertionSortImpl} is faster than {@link SelectionSortImpl} for h-sorting because h decrease, the array become partially sorted
     *
     * {@link #insertionSortAndPrintTrack(Character[])} get less comparisons(N^2/4) in partially sorted arrays
     *  than {@link #hSortedOnSelectionSort(Character[])}, which is (N^2/2)
     *
     * When h-sorting, using {@link #hSortedOnSelectionSort(Character[])} is same as the standard {@link SelectionSortImpl} implementation,
     * which is unnecessary
     */
    private void hSortedOnSelectionSort(Character[] array) {
        int h = getH(array);
        int len = array.length;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int min = i;
                Character tmp = array[min];
                while ((min - h) >= 0 && array[min - h] > tmp) {
                    min -= h;
                    array[i] = array[min];
                    array[min] = tmp;
                }
            }
            h /= 3;
        }
    }

    @Test
    void _2_1_14() {
        IList<Character> chars = FileUtil.readChars("data/gnome/genomeTiny.txt");
        assert chars != null;
        ArraysUtil.display(chars);
        Object[] characters = chars.toArray();
        Character[] array = new Character[characters.length];
        for (int i = 0; i < characters.length; i++) {
            array[i] = (Character) characters[i];
        }

        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * find best / worst cases of {@link com.algs.algo.sort.array.cmp_swp.shell.ShellSortImpl}
     *
     * max:452
     * worst: {25, 30, 18, 2, 26, 30, 10, 6, 13, 25, 1, 11, 23, 19, 28, 11, 15, 9, 26, 7, 7, 24, 28, 2, 12, 15, 27, 28, 8, 12}
     * min:192
     * best: {22, 23, 8, 19, 24, 17, 10, 7, 25, 27, 5, 22, 30, 16, 29, 11, 5, 5, 23, 25, 26, 6, 7, 27, 23, 25, 29, 2, 30, 27}
     */
    @Test
    void _2_1_19() {
        int max = 0;
        int min = Integer.MAX_VALUE;
        Integer[] worst = new Integer[0];
        Integer[] best  = new Integer[0];
        for (int i = 0; i < 50000000; i++) {
            Integer[] array = ArrayGenerator.randomIntArray(30);
            CompareAndSwapSortAlys<Integer> sort = new ShellSortAlysImpl<>(ArraysUtil.copy(array));
            sort.sort();
            int cost = sort.getCost();
            if (cost > max) {
                max = cost;
                worst = array;
            }
            if (cost < min) {
                min = cost;
                best = array;
            }
        }

        System.out.println("max:" + max);
        System.out.println("worst: " + ArraysUtil.toString(worst));

        System.out.println("min:" + min);
        System.out.println("best: " + ArraysUtil.toString(best));

    }

}
