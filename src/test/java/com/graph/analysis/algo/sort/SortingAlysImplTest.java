package com.graph.analysis.algo.sort;

import com.algs.util.ArraysUtil;
import org.junit.jupiter.api.Test;

class SortingAlysImplTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {
//                SelectionSortAlysImpl.class,
//                InsertionSortAlysImpl.class,
                ShellSortAlysImpl.class
        };

        exec(klasses);
    }

    /**
     * {@link SelectionSortAlysImpl}
     *  10000:  306, Cost (100078367),  Cmp (49995000),  Swap (10000)
     *  20000: 1017, Cost (400170712),  Cmp (199990000), Swap (20000)
     *  40000: 3839, Cost (1600365907), Cmp (799980000), Swap (40000)
     *
     *  {@link com.algs.algo.sort.InsertionSortImpl}
     *  10000: 386, Cost (49909883), Cmp (24959938), Swap (24949945)
     *         267, Cost (24970088), Cmp (24970088), Swap (24970099)    Move
     *         188, Cost (248013),   Cmp (119007),   Swap (101)         BinarySearch
     *  20000: 1251, Cost (199505159), Cmp (99762575), Swap (99742584)
     *         861,  Cost (101083349), Cmp (101063349), Swap (101063360)
     *         633,  Cost (535961),    Cmp (257981),    Swap (3411)
     *  40000: 6037, Cost (804709444), Cmp (402374714), Swap (402334730)
     *         3501, Cost (399640302), Cmp (399600302), Swap (399600314)
     *         3048, Cost (1151987),   Cmp (555994),    Swap (1193)
     *
     *  {@link com.algs.algo.sort.ShellSortImpl}
     *  10000: 42, Cost (417065),  Cmp (243995),  Swap (173070)
     *  20000: 56, Cost (930147),  Cmp (542920),  Swap (387227)
     *  40000: 64, Cost (2230658), Cmp (1285015), Swap (945643)
     *
     */
    private void exec(Class<?>[] klasses) {
        Integer[] array = ArraysUtil.randomIntArray(40000);
        System.out.println("Init done");

        for (Class<?> klass : klasses) {
            SortAlysCompare<Integer> alys = new SortAlysCompare<>(array, klass);
            alys.exec();
        }
    }
}