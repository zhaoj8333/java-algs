package com.algs.application.datastructure.collection.heap;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.util.FileUtil;
import org.junit.jupiter.api.Test;

class TopkIssueTest {

    @Test
    void test() {
        IList<Integer> list = FileUtil.readInts("data/ints/8ints.txt");
        TopkIssue<Integer> topk = new TopkIssue<>();
        ICollection<Integer> integers = topk.solution(list, (a, b) -> b - a, 5);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}