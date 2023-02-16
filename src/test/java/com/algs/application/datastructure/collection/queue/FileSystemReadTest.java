package com.algs.application.datastructure.collection.queue;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

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

    @Test
    void getTestData() {
        FileSystemRead fsr = new FileSystemRead();
        String fullPath = "/home/allen/Project/algs-java/src/main/resources/data/";
        IQueue<String> files = fsr.read(fullPath);
        Iterator<String> itr = files.iterator();
        while (itr.hasNext()) {
            String fullName = itr.next();
            File file = new File(fullName);
            if (file.isFile()) {
                String auxPath = fullName.replace(fullPath, "");
                String name = file.getName();
                String upperName = name.toUpperCase();
                String replace = upperName.replace("/", "_");
                String result = replace.replace(".", "_");
                result = result.replace("TINY", "_TINY_");
                result = result.replace("MEDIUM", "_MEDIUM_");
                result = result.replace("LARGE", "_LARGE_");
                result = result.replace("__", "_");
                if (result.startsWith("_")) {
                    result = result.substring(1);
                }

                System.out.println(" public static String " + result + " = " + "\"" + "data/" + auxPath + "\";");
            }
        }
    }
}