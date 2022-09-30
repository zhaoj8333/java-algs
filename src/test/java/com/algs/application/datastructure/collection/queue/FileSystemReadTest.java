package com.algs.application.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemReadTest {

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