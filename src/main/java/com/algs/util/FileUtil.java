package com.algs.util;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.SinglyLinkedListImpl;

import java.io.*;
import java.net.URL;
import java.util.Objects;

public class FileUtil {

    public static IList<Integer> readInts(String fileName) {
        URL resource = FileUtil.class.getClassLoader().getResource(fileName);
        if (Objects.isNull(resource)) {
            return null;
        }
        File file = new File(resource.getFile());
        IList<Integer> ints = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            LineNumberReader lnr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                lnr = new LineNumberReader(isr);
                String line;
                while ((line = lnr.readLine()) != null) {
                    ints.add(Integer.valueOf(line.trim()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (isr != null) {
                        isr.close();
                    }
                    if (lnr != null) {
                        lnr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ints;
    }


}
