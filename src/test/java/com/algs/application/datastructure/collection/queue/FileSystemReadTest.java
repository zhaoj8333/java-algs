package com.algs.application.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileSystemReadTest {

    @Test
    void readRecursively() {
        FileSystemRead fsr = new FileSystemRead();
        IQueue<String> f1 = fsr.readRecursively("/opt/google/chrome/");
        Iterator<String> itr = f1.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }

        IQueue<String> f2 = fsr.read("/opt/google/chrome/");
        Assertions.assertEquals(f1.size(), f2.size());
    }

    @Test
    void read() {
        FileSystemRead fsr = new FileSystemRead();
        IQueue<String> files = fsr.read("/opt/google/chrome/");
        Iterator<String> itr = files.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}